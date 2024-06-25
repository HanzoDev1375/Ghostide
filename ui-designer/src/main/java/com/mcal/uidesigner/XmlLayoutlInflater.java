package com.mcal.uidesigner;

import static com.mcal.uidesigner.utils.FileHelper.readFile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;

import com.mcal.uidesigner.common.PositionalXMLReader;
import com.mcal.uidesigner.common.UndoManager;
import com.mcal.uidesigner.common.ValueRunnable;
import com.mcal.uidesigner.utils.Utils;
import com.mcal.uidesigner.view.IncludeLayout;
import com.mcal.uidesigner.widget.ClickableBorder;

import org.jetbrains.annotations.Contract;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class XmlLayoutlInflater implements UndoManager.UndoRedoListener {
    private final Context context;
    private final XmlLayoutResourceFinder finder;
    private final ViewGroup parentView;
    private final UndoManager undoManager;
    private final Map<String, Node> id2Node = new HashMap<>();
    private final Map<String, Integer> id2Int = new HashMap<>();
    private final List<XmlLayoutEditView> editViews = new ArrayList<>();
    private boolean border;
    private Document document;
    private Throwable documentParseException;
    private boolean editMode;
    private ValueRunnable<XmlLayoutEditView> selectModeClickRunnable;
    private ArrayList<Element> selectModeNodes;
    private String xmlContent;
    private String xmlFilePath;

    public XmlLayoutlInflater(@NonNull ViewGroup parent, String xmlFilePath, String resDirPath, @NonNull UndoManager undoManager) {
        undoManager.addListener(this);
        this.undoManager = undoManager;
        this.context = parent.getContext();
        this.parentView = parent;
        this.xmlFilePath = xmlFilePath;
        this.finder = new XmlLayoutResourceFinder(context, resDirPath);
    }

    protected abstract void onEmptyLayoutClicked();

    protected abstract void onInflated();

    protected abstract void onViewClicked(XmlLayoutEditView xmlLayoutEditView);

    protected abstract void onXmlModified(boolean z);

    public String getXmlFilePath() {
        return this.xmlFilePath;
    }

    public void setXmlFilePath(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        undoManager.addBaseVersion(xmlFilePath, xmlContent, 0);
        inflate();
    }

    public void init() {
        xmlContent = readFile(xmlFilePath);
        undoManager.addBaseVersion(getXmlFilePath(), xmlContent, 0);
        inflate();
    }

    public String getXml() {
        return xmlContent;
    }

    public List<XmlLayoutEditView> getEditViews() {
        return new ArrayList<>(editViews);
    }

    public boolean canPaste() {
        @SuppressLint("WrongConstant") ClipboardManager cm = (ClipboardManager) context.getSystemService("clipboard");
        return cm.hasText() && cm.getText().charAt(0) == '<';
    }

    @SuppressLint("WrongConstant")
    public void paste() {
        xmlContent = ((ClipboardManager) context.getSystemService("clipboard")).getText().toString();
        undoManager.addVersion(getXmlFilePath(), xmlContent, 0);
        inflate();
        onXmlModified(true);
    }

    @SuppressLint("WrongConstant")
    public void copy() {
        ((ClipboardManager) context.getSystemService("clipboard")).setText(getXml());
    }

    public void share() {
        final Uri logUri = FileProvider.getUriForFile(context, context.getPackageName(), new File(xmlFilePath));

        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, logUri);
        intent.putExtra(Intent.EXTRA_SUBJECT, new File(xmlFilePath).getName());
        intent.setType("application/xml");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, "Share via..."));
    }

    @Override
    public void revertToVersion(@NonNull String filepath, String content, int change) {
        if (filepath.equals(getXmlFilePath())) {
            xmlContent = content;
            inflate();
            onXmlModified(false);
        }
    }

    @Override
    public void undoRedoStateChanged() {
    }

    public void setShowBorder(boolean show) {
        border = show;
        refresh();
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
        selectModeClickRunnable = null;
        refresh();
    }

    public List<String> getAllIDs() {
        return new ArrayList<>(id2Node.keySet());
    }

    public void setIDAttribute(@NonNull Element node, @NonNull XmlLayoutProperties.PropertySpec property, Element otherNode, String id) {
        node.setAttribute(property.attrName, "@id/" + id);
        if (otherNode != null) {
            otherNode.setAttribute("android:id", "@+id/" + id);
        }
        serializeXml();
    }

    public void setViewID(Element node, String id) {
        if (id == null) {
            node.removeAttribute("android:id");
        } else {
            String oldId = getViewID(node);
            node.setAttribute("android:id", "@+id/" + id);
            if (oldId != null) {
                renameId(document, "@id/" + oldId, "@id/" + id);
            }
        }
        serializeXml();
    }

    private void renameId(Node node, String oldValue, String newValue) {
        if (node instanceof Element) {
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Attr attr = (Attr) attributes.item(i);
                if (oldValue.equals(attr.getValue())) {
                    attr.setValue(newValue);
                }
            }
        }
        NodeList childNodes = node.getChildNodes();
        if (childNodes != null) {
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                renameId(childNodes.item(i2), oldValue, newValue);
            }
        }
    }

    public String suggestViewID(Element node) {
        String fileName = xmlFilePath == null ? "" : new File(xmlFilePath).getName().replace("_", "");
        if (fileName.lastIndexOf(46) != -1) {
            fileName = fileName.substring(0, fileName.lastIndexOf(46));
        }
        String nodeName = node.getNodeName();
        if (nodeName.lastIndexOf(46) != -1) {
            nodeName = nodeName.substring(nodeName.lastIndexOf(46) + 1);
        }
        String name = fileName + nodeName;
        int i = 1;
        while (id2Node.containsKey(name + i)) {
            i++;
        }
        return name + i;
    }

    public String suggestUserDrawableName() {
        return finder.suggestUserDrawableName();
    }

    public void addUserDrawable(String name, Intent data) {
        finder.addUserDrawable(name, data);
    }

    public List<String> getAllUserDrawables() {
        return finder.getAllUserDrawables();
    }

    public List<String> getAllUserStyles() {
        return finder.getAllUserStyles();
    }

    public List<AttributeValue> getAttributes(PropertyObject viewObj, PropertyObject layoutParamsObj, Element node) {
        List<AttributeValue> attributes = new ArrayList<>();
        XmlLayoutProperties.PropertySpec[] arr = XmlLayoutProperties.SORTED_PROPERTIES;
        for (XmlLayoutProperties.PropertySpec property : arr) {
            if (property.isLayoutProperty) {
                if (layoutParamsObj.hasProperty(property)) {
                    attributes.add(getPropertyValue(node, property));
                }
            } else if (viewObj.hasProperty(property)) {
                attributes.add(getPropertyValue(node, property));
            }
        }
        List<AttributeValue> result = new ArrayList<>();
        for (AttributeValue attribute : attributes) {
            if (attribute.hasValue() && !attribute.isStyled()) {
                result.add(attribute);
            }
        }
        for (AttributeValue attribute2 : attributes) {
            if (attribute2.isStyled()) {
                result.add(attribute2);
            }
        }
        for (AttributeValue attribute3 : attributes) {
            if (!attribute3.hasValue()) {
                result.add(attribute3);
            }
        }
        return result;
    }

    public void setAttribute(Element node, @NonNull XmlLayoutProperties.PropertySpec property, String value) {
        Map<String, String> eventProperties = new HashMap<>();
        eventProperties.put("attrName", property.attrName);
        eventProperties.put("value", value);
        if (value == null) {
            node.removeAttribute(property.attrName);
        } else {
            node.setAttribute(property.attrName, value);
        }
        serializeXml();
    }

    public void deleteView(@NonNull Element node) {
        node.getParentNode().removeChild(node);
        serializeXml();
    }

    public boolean hasView() {
        return document.getChildNodes().getLength() > 0;
    }

    public void surroundWithView(@NonNull Element node, NewWidget widget) {
        Element newNode = createElement(widget);
        Node parentNode = node.getParentNode();
        Node nextSibling = node.getNextSibling();
        parentNode.removeChild(node);
        if (nextSibling != null) {
            parentNode.insertBefore(newNode, nextSibling);
        } else {
            parentNode.appendChild(newNode);
        }
        newNode.appendChild(node);
        removeLayoutAttributes(node);
        serializeXml();
    }

    private void removeLayoutAttributes(Element node) {
        XmlLayoutProperties.PropertySpec[] arr = XmlLayoutProperties.LAYOUT_PROPERTIES;
        for (XmlLayoutProperties.PropertySpec property : arr) {
            if (!(property == XmlLayoutProperties.LAYOUT_WIDTH || property == XmlLayoutProperties.LAYOUT_HEIGHT || !node.hasAttribute(property.attrName))) {
                node.removeAttribute(property.attrName);
            }
        }
    }

    public void addViewBehind(@NonNull Element node, NewWidget widget) {
        Element newNode = createElement(widget);
        if (node.getNextSibling() != null) {
            node.getParentNode().insertBefore(newNode, node.getNextSibling());
        } else {
            node.getParentNode().appendChild(newNode);
        }
        serializeXml();
    }

    public void addViewBefore(@NonNull Element node, NewWidget widget) {
        node.getParentNode().insertBefore(createElement(widget), node);
        serializeXml();
    }

    public void addViewInside(@NonNull Element node, NewWidget widget) {
        node.appendChild(createElement(widget));
        serializeXml();
    }

    public void addViewInside(@NonNull Element node, NewWidget widget, @NonNull Element otherNode, @NonNull XmlLayoutProperties.PropertySpec layoutProperty, String id) {
        Element newNode = createElement(widget);
        node.appendChild(newNode);
        newNode.setAttribute(layoutProperty.attrName, "@id/" + id);
        otherNode.setAttribute("android:id", "@+id/" + id);
        serializeXml();
    }

    public void addView(NewWidget widget) {
        document.appendChild(createElement(widget));
        serializeXml();
    }

    public void onViewTaped(XmlLayoutEditView editView) {
        if (selectModeClickRunnable != null) {
            selectModeClickRunnable.run(editView);
            selectModeClickRunnable = null;
            refresh();
            return;
        }
        onViewClicked(editView);
    }

    public void startSelectingOtherView(@NonNull Element node, ValueRunnable<XmlLayoutEditView> ok) {
        selectModeClickRunnable = ok;
        selectModeNodes = new ArrayList<>();
        NodeList childNodes = node.getParentNode().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child instanceof Element) {
                if (child.equals(node)) {
                    break;
                }
                selectModeNodes.add((Element) child);
            }
        }
        refresh();
    }

    private Element createElement(@NonNull NewWidget widget) throws DOMException {
        Element childNode = document.createElement(widget.elementName);
        for (Map.Entry<String, String> entry : widget.attributes.entrySet()) {
            childNode.setAttribute(entry.getKey(), entry.getValue());
        }
        return childNode;
    }

    private void serializeXml() {
        xmlContent = new XmlLayoutDOMSerializer().serialize(document);
        undoManager.addVersion(getXmlFilePath(), xmlContent, 0);
        inflate();
        onXmlModified(true);
    }

    private void inflate() {
        try {
            documentParseException = null;
            id2Node.clear();
            id2Int.clear();
            finder.reload();
            InputStream in = new ByteArrayInputStream(xmlContent.getBytes());
            document = PositionalXMLReader.readXML(in);
            in.close();
            collectIDs(document.getChildNodes());
        } catch (Throwable t) {
            documentParseException = t;
            try {
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        selectModeClickRunnable = null;
        refresh();
    }

    @SuppressLint("SetTextI18n")
    private void refresh() {
        ViewGroup container;
        this.parentView.removeAllViews();
        if (border || editMode) {
            container = new LinearLayout(context);
            ((LinearLayout) container).setGravity(17);
            ClickableBorder clickableBorder = new ClickableBorder(context, container) {
                @Override
                protected void onClicked() {
                    if (editMode && !hasView()) {
                        onEmptyLayoutClicked();
                    }
                }
            };
            clickableBorder.setEnabled(editMode);
            parentView.addView(clickableBorder, -1, -1);
        } else {
            container = parentView;
        }
        Throwable inflateException = documentParseException;
        this.editViews.clear();
        if (inflateException == null) {
            try {
                inflateElements(document.getChildNodes(), container, null, 0);
                parentView.invalidate();
            } catch (Exception e) {
                inflateException = e;
            }
        }
        if (inflateException != null) {
            TextView textView = new TextView(context);
            if (!inflateException.getMessage().contains("no element")) {
                textView.setText(context.getString(R.string.can_not_view_the_layout) + inflateException.getMessage());
            } else if (editMode) {
                textView.setText(R.string.no_views_have_been_added);
            } else {
                textView.setText(R.string.no_views_hava_been_added);
            }
            int p = (int) (10.0f * context.getResources().getDisplayMetrics().density);
            textView.setPadding(p, p, p, p);
            textView.setTextSize(20.0f);
            container.removeAllViews();
            container.addView(textView);
        }
        onInflated();
    }

    private void collectIDs(@NonNull NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == 1) {
                String id = getViewID(node);
                if (id != null && !id2Int.containsKey(id)) {
                    id2Node.put(id, node);
                    id2Int.put(id, id2Int.size() + 100);
                }
                collectIDs(node.getChildNodes());
            }
        }
    }

    public String getViewID(@NonNull Node node) {
        String idValue;
        Node attr = node.getAttributes().getNamedItem("android:id");
        if (!(attr instanceof Attr) || (idValue = ((Attr) attr).getValue()) == null || !idValue.startsWith("@+id/")) {
            return null;
        }
        return idValue.substring("@+id/".length());
    }

    public String getStyle(@NonNull Element node) {
        Node styleAttr = node.getAttributes().getNamedItem("style");
        if (styleAttr instanceof Attr) {
            return ((Attr) styleAttr).getValue();
        }
        return null;
    }

    public void setStyle(Element node, String style) {
        if (style == null) {
            node.removeAttribute("style");
        } else {
            node.setAttribute("style", style);
        }
        serializeXml();
    }

    private void inflateElements(@NonNull NodeList nodes, ViewGroup parent, XmlLayoutEditView parentEditView, int depth) {
        PropertyObject viewObj;
        View actualView;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == 1) {
                String elementName = node.getNodeName();
                View view = inflateView(node, elementName);
                if (view != null) {
                    configureView(view, editMode);
                    viewObj = new PropertyObject(view);
                    inflateAttributes(viewObj, node, XmlLayoutProperties.VIEW_PROPERTIES);
                } else {
                    view = new TextView(context);
                    ((TextView) view).setText(elementName);
                    int p = (int) (5.0f * context.getResources().getDisplayMetrics().density);
                    view.setPadding(p, p, p, p);
                    if (this.editMode) {
                        int minSize = (int) (20.0f * context.getResources().getDisplayMetrics().density);
                        view.setMinimumHeight(minSize);
                        view.setMinimumWidth(minSize);
                    }
                    viewObj = new PropertyObject(new View(context));
                }
                PropertyObject layoutParamsObj = inflateLayoutParams(node, parent);
                boolean showEditView = editMode && !(view instanceof TableRow) && (selectModeClickRunnable == null || selectModeNodes.contains(node));
                XmlLayoutEditView editView = new XmlLayoutEditView(context, showEditView ? view : null, (Element) node, viewObj, layoutParamsObj, parentEditView, depth, this);
                this.editViews.add(editView);
                if (showEditView) {
                    actualView = editView;
                } else {
                    actualView = view;
                }
                String id = getViewID(node);
                if (id != null) {
                    actualView.setId(id2Int.get(id));
                }
                if (parent != null) {
                    parent.addView(actualView, (ViewGroup.LayoutParams) layoutParamsObj.obj);
                }
                ViewGroup viewGroup = null;
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                }
                inflateElements(node.getChildNodes(), viewGroup, editView, depth + 1);
            }
        }
    }

    private void configureView(View view, boolean editMode) {
        if (editMode) {
            int minSize = (int) (20.0f * context.getResources().getDisplayMetrics().density);
            view.setMinimumHeight(minSize);
            view.setMinimumWidth(minSize);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(false);
                ((ViewGroup) view).setClipToPadding(false);
            }
            view.setFocusable(false);
            if (view.getClass() == TextView.class || view.getClass() == Button.class) {
                ((TextView) view).setText(view.getClass().getSimpleName());
            }
        }
        if (view.getClass() == ListView.class) {
            fillListView((ListView) view);
        }
        if (view.getClass().equals(Spinner.class)) {
            fillSpinner((Spinner) view);
        }
        if (view.getClass() == ExpandableListView.class) {
            fillExpandableListView((ExpandableListView) view);
        }
    }

    private void fillExpandableListView(@NonNull ExpandableListView view) {
        view.setAdapter(new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return 30;
            }

            @Override
            public int getChildrenCount(int p1) {
                return 2;
            }

            @Override
            public Object getGroup(int p1) {
                return null;
            }

            @Override
            public Object getChild(int p1, int p2) {
                return null;
            }

            @Override
            public long getGroupId(int p1) {
                return p1;
            }

            @Override
            public long getChildId(int p1, int p2) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                View view = convertView;
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
                }
                ((TextView) view.findViewById(android.R.id.text1)).setText(context.getString(R.string.group_) + (groupPosition + 1));
                return view;
            }

            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                View view2 = convertView;
                if (view2 == null) {
                    view2 = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_2, parent, false);
                }
                ((TextView) view2.findViewById(android.R.id.text1)).setText(context.getString(R.string.item_) + (childPosition + 1));
                ((TextView) view2.findViewById(16908309)).setText(context.getString(R.string.item_) + (childPosition + 1));
                return view2;
            }

            @Override
            public boolean isChildSelectable(int p1, int p2) {
                return true;
            }
        });
    }

    @SuppressLint("ResourceType")
    private void fillSpinner(Spinner view) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add("Item " + i);
        }
        view.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, items));
    }

    @SuppressLint("ResourceType")
    private void fillListView(ListView view) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add("Item " + i);
        }
        view.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, items));
    }

    @Nullable
    private View inflateView(Node node, @NonNull String elementName) {
        if ("View".equals(elementName) || "view".equals(elementName)) {
            return new View(context);
        }
        if (elementName.equals("include") || elementName.equals("merge")) {
            return new IncludeLayout(context);
        }
        if (!elementName.contains(".")) {
            elementName = "android.widget." + elementName;
        }
        final String baseStyle = finder.getBaseStyle(getStyle((Element) node));
        if (baseStyle != null && baseStyle.startsWith("@android:style/")) {
            try {
                return (View) Class.forName(elementName).getConstructor(Context.class, AttributeSet.class, Integer.TYPE).newInstance(context, null, Integer.valueOf(((Integer) R.attr.class.getField("Android_" + baseStyle.substring("@android:style/".length()).replace(".", "_")).get(null)).intValue()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        if (baseStyle != null && baseStyle.startsWith("?android:attr/")) {
            try {
                return (View) Class.forName(elementName).getConstructor(Context.class, AttributeSet.class, Integer.TYPE).newInstance(context, null, R.attr.class.getField(baseStyle.substring("?android:attr/".length())).get(null));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        try {
            return (View) Class.forName(elementName).getConstructor(Context.class).newInstance(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @NonNull
    private PropertyObject inflateLayoutParams(Node node, ViewGroup parent) {
        ViewGroup.LayoutParams layoutParams;
        try {
            Class<?> layoutParamsClass = Class.forName(parent.getClass().getName() + "$LayoutParams");
            try {
                layoutParams = (ViewGroup.LayoutParams) layoutParamsClass.getConstructor(Integer.TYPE, Integer.TYPE).newInstance(-2, -2);
            } catch (NoSuchMethodException e) {
                layoutParams = (ViewGroup.LayoutParams) layoutParamsClass.getConstructor(ViewGroup.LayoutParams.class).newInstance(new ViewGroup.LayoutParams(-1, -1));
            }
            PropertyObject obj = new PropertyObject(layoutParams);
            String baseStyle = finder.getBaseStyle(getStyle((Element) node));
            if (baseStyle != null && baseStyle.startsWith("?android:attr/")) {
                try {
                    TypedArray array = context.getTheme().obtainStyledAttributes((Integer) R.attr.class.getField(baseStyle.substring("?android:attr/".length())).get(null), new int[]{android.R.attr.layout_width, android.R.attr.layout_height});
                    if (array.hasValue(0)) {
                        layoutParams.width = array.getLayoutDimension(0, "layout_width");
                    }
                    if (array.hasValue(1)) {
                        layoutParams.height = array.getLayoutDimension(1, "layout_height");
                    }
                    array.recycle();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            inflateAttributes(obj, node, XmlLayoutProperties.LAYOUT_PROPERTIES);
            return obj;
        } catch (Throwable th2) {
            return new PropertyObject(new ViewGroup.LayoutParams(-2, -2));
        }
    }

    private void inflateAttributes(PropertyObject obj, Node node, @NonNull XmlLayoutProperties.PropertySpec[] properties) {
        int min;
        for (XmlLayoutProperties.PropertySpec property : properties) {
            if (obj.hasProperty(property)) {
                Object value = getPropertyAttributeValue(node, property);
                if (editMode && (value instanceof Integer) && ((property == XmlLayoutProperties.LAYOUT_WIDTH || property == XmlLayoutProperties.LAYOUT_HEIGHT) && (Integer) value >= 0 && (Integer) value < (min = (int) (10.0f * this.context.getResources().getDisplayMetrics().density)))) {
                    value = min;
                }
                obj.setProperty(property, value);
            }
        }
    }

    private Object getPropertyAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        Object val = getSystemStyleAttributeValue(node, property);
        return val != null ? val : getDirectPropertyAttributeValue(node, property);
    }

    @Nullable
    private Object getSystemStyleAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        try {
            String stringValue = getPropertyValue(node, property).value;
            if (stringValue != null && stringValue.startsWith("?android:attr/")) {
                int attrID = Utils.getAndroidResourceID(android.R.attr.class.getName(), stringValue);
                switch (property.type) {
                    case Size:
                    case TextSize:
                    case LayoutSize:
                    case FloatSize:
                        TypedValue value = new TypedValue();
                        if (context.getTheme().resolveAttribute(attrID, value, true)) {
                            return (int) TypedValue.complexToDimension(value.data, context.getResources().getDisplayMetrics());
                        }
                        break;
                    default:
                        TypedArray a = context.obtainStyledAttributes(new int[]{attrID});
                        if (a.hasValue(0)) {
                            switch (property.type) {
                                case Bool:
                                    Boolean valueOf = a.getBoolean(0, false);
                                    a.recycle();
                                    return valueOf;
                                case ID:
                                case Int:
                                case IntConstant:
                                    Integer valueOf2 = a.getInt(0, 0);
                                    a.recycle();
                                    return valueOf2;
                                case Float:
                                    Float valueOf3 = a.getFloat(0, 0.0f);
                                    a.recycle();
                                    return valueOf3;
                                case Color:
                                    Integer valueOf4 = a.getColor(0, 0);
                                    a.recycle();
                                    return valueOf4;
                                case DrawableResource:
                                case Drawable:
                                    Drawable drawable = a.getDrawable(0);
                                    a.recycle();
                                    return drawable;
                                case Text:
                                    String string = a.getString(0);
                                    a.recycle();
                                    return string;
                            }
                        }
                        a.recycle();
                        break;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Nullable
    private Object getDirectPropertyAttributeValue(Node node, @NonNull XmlLayoutProperties.PropertySpec property) {
        switch (property.type) {
            case Bool:
                return getBoolAttributeValue(node, property);
            case ID:
                return getIDAttributeValue(node, property);
            case Int:
                return getIntAttributeValue(node, property);
            case IntConstant:
                return getIntConstantAttributeValue(node, property);
            case Float:
                return getFloatAttributeValue(node, property);
            case Color:
                return getColorAttributeValue(node, property);
            case DrawableResource:
                return getDrawableAttributeValue(node, property);
            case Drawable:
                Integer value = getColorAttributeValue(node, property);
                if (value != null) {
                    return new ColorDrawable(value);
                }
                return getDrawableAttributeValue(node, property);
            case Text:
                return getStringAttributeValue(node, property);
            case EnumConstant:
                return getEnumConstantAttributeValue(node, property);
            case TextAppearance:
                return getResourcePropertyValue(node, property);
            case Size:
                return getSizeAttributeValue(node, property);
            case TextSize:
                return getTextSizeAttributeValue(node, property);
            case LayoutSize:
                Integer value2 = getSizeAttributeValue(node, property);
                if (value2 != null) {
                    return value2;
                }
                return getIntConstantAttributeValue(node, property);
            case FloatSize:
                return getSizeAttributeValue(node, property);
            default:
                return null;
        }
    }

    @Nullable
    private Boolean getBoolAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value == null) {
            return null;
        }
        return "true".equals(value);
    }

    @Nullable
    private Object getDrawableAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        Drawable drawable = finder.findUserDrawable(value);
        if (drawable != null) {
            return drawable;
        }
        if (value != null && value.startsWith("@android:drawable/")) {
            try {
                return ResourcesCompat.getDrawable(context.getResources(), Utils.getAndroidResourceID(android.R.drawable.class.getName(), "@android:drawable/"), context.getTheme());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    private Enum<?> getEnumConstantAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        try {
            String value = getResourcePropertyValue(node, property);
            if (value != null) {
                Field[] arr$ = property.constantClass.getFields();
                for (Field field : arr$) {
                    String fieldName = field.getName();
                    if ((field.getModifiers() & 8) != 0 && fieldName.replace("_", "").equals(value.toUpperCase())) {
                        return (Enum) field.get(null);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Nullable
    private Integer getIntConstantAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value == null) {
            return null;
        }
        int result = 0;
        for (String val : value.split("\\|")) {
            Integer c = getIntConstantAttributeValue(val, property);
            if (c != null) {
                result |= c;
            }
        }
        return result;
    }

    @Nullable
    private Integer getIntConstantAttributeValue(String value, @NonNull XmlLayoutProperties.PropertySpec property) {
        if (property.constantFieldPrefix == null) {
            try {
                return (Integer) property.constantClass.getField(value.toUpperCase()).get(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        Field[] arr$ = property.constantClass.getFields();
        for (Field field : arr$) {
            String fieldName = field.getName();
            if ((field.getModifiers() & 8) != 0 && fieldName.startsWith(property.constantFieldPrefix) && fieldName.substring(property.constantFieldPrefix.length()).replace("_", "").equalsIgnoreCase(value)) {
                try {
                    return (Integer) field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private String getStringAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        return getResourcePropertyValue(node, property);
    }

    @Nullable
    private Integer getColorAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value != null) {
            try {
                if (value.charAt(0) == '#') {
                    return Color.parseColor(value);
                } else if (value.startsWith("@android:color/")) {
                    return ResourcesCompat.getColor(context.getResources(), Utils.getAndroidResourceID(android.R.color.class.getName(), value), context.getTheme());
                } else if (value.startsWith("@color/")) {
                    return Color.parseColor(finder.findUserResourceValue(value));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    private Float getTextSizeAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        Integer size = getSizeAttributeValue(node, property);
        if (size != null) {
            return ((float) size) / context.getResources().getDisplayMetrics().scaledDensity;
        }
        return null;
    }

    @Nullable
    private Integer getSizeAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value != null) {
            try {
                float v = 0f;
                if (!(value.startsWith("@") || value.startsWith("?") || value.startsWith("wrap") || value.startsWith("match") || value.startsWith("fill"))) {
                    v = Float.parseFloat(value.substring(0, value.length() - 2));
                }
                if (value.endsWith("px")) {
                    return (int) v;
                }
                if (value.endsWith("dp")) {
                    return (int) (context.getResources().getDisplayMetrics().density * v);
                } else if (value.endsWith("dip")) {
                    return (int) (context.getResources().getDisplayMetrics().density * Float.parseFloat(value.substring(0, value.length() - 3)));
                } else if (value.endsWith("sp")) {
                    return (int) (context.getResources().getDisplayMetrics().scaledDensity * v);
                } else if (value.startsWith("@android:dimen/")) {
                    return context.getResources().getDimensionPixelSize(Utils.getAndroidResourceID(android.R.dimen.class.getName(), "@android:dimen/"));
                } else if (value.startsWith("@dimen/")) {
                    value = finder.findUserResourceValue(value);
                    if (value != null) {
                        v = Float.parseFloat(value.substring(0, value.length() - 2));
                        return (int) v;
                    }
                }
            } catch (Throwable th) {
                Log.e(getClass().getCanonicalName(), "\n" +
                        "Line Number: " + node.getUserData(PositionalXMLReader.LINE) + "\n" +
                        "Column Number: " + node.getUserData(PositionalXMLReader.COLUMN) + "\n" +
                        node.getNodeName() + "\n" +
                        property.attrName + " = " + value + "\n"
                );
                th.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    private Integer getIntAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    private Float getFloatAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String value = getResourcePropertyValue(node, property);
        if (value != null) {
            try {
                return Float.parseFloat(value);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    private Integer getIDAttributeValue(Node node, XmlLayoutProperties.PropertySpec property) {
        String val = getResourcePropertyValue(node, property);
        if (val != null) {
            if (val.startsWith("@+id/")) {
                String id = val.substring("@+id/".length());
                if (id2Int.containsKey(id)) {
                    return id2Int.get(id);
                }
            }
            if (val.startsWith("@id/")) {
                String id = val.substring("@id/".length());
                if (id2Int.containsKey(id)) {
                    return id2Int.get(id);
                }
            }
            if (val.startsWith("@android:id/")) {
                String id = val.substring("@android:id/".length());
                if (id2Int.containsKey(id)) {
                    return id2Int.get(id);
                }
            }
        }
        return null;
    }

    private String getResourcePropertyValue(Node node, XmlLayoutProperties.PropertySpec property) {
        return finder.findResourcePropertyValue(getPropertyValue(node, property).value);
    }

    @NonNull
    @Contract("_, _ -> new")
    private AttributeValue getPropertyValue(@NonNull Node node, @NonNull XmlLayoutProperties.PropertySpec property) {
        String value;
        Node attr = node.getAttributes().getNamedItem(property.attrName);
        if (attr instanceof Attr) {
            return new AttributeValue(property, (Attr) attr);
        }
        String style = getStyle((Element) node);
        if (style == null || (value = finder.findStyleAttributeValue(style, property)) == null) {
            return new AttributeValue(property);
        }
        return new AttributeValue(property, value);
    }
}
