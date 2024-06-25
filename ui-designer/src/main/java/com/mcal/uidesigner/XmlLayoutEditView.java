package com.mcal.uidesigner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.mcal.uidesigner.common.PositionalXMLReader;
import com.mcal.uidesigner.common.ValueRunnable;
import com.mcal.uidesigner.widget.ClickableBorder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

@SuppressLint("ViewConstructor")
public class XmlLayoutEditView extends ClickableBorder {
    private final int depth;
    private final XmlLayoutlInflater inflater;
    private final PropertyObject layoutParamsObj;
    private final Element node;
    private final XmlLayoutEditView parent;
    private final PropertyObject viewObj;

    public XmlLayoutEditView(Context context, View view, Element node, PropertyObject viewObj, PropertyObject layoutParamsObj, XmlLayoutEditView parent, int depth, XmlLayoutlInflater inflater) {
        super(context, view);
        this.node = node;
        this.viewObj = viewObj;
        this.layoutParamsObj = layoutParamsObj;
        this.inflater = inflater;
        this.parent = parent;
        this.depth = depth;
    }

    @Override
    protected void onClicked() {
        this.inflater.onViewTaped(this);
    }

    public int getSourceLine() {
        return Integer.parseInt((String) this.node.getUserData(PositionalXMLReader.LINE));
    }

    public int getSourceColumn() {
        return Integer.parseInt((String) this.node.getUserData(PositionalXMLReader.COLUMN));
    }

    public String getNodeName() {
        return this.node.getNodeName();
    }

    public List<String> getAllUserDrawables() {
        return this.inflater.getAllUserDrawables();
    }

    public String suggestUserDrawableName() {
        return this.inflater.suggestUserDrawableName();
    }

    public void addUserDrawable(String name, Intent data) {
        this.inflater.addUserDrawable(name, data);
    }

    public List<String> getAllUserStyles() {
        return this.inflater.getAllUserStyles();
    }

    public String getStyle() {
        return this.inflater.getStyle(this.node);
    }

    public void setStyle(String style) {
        this.inflater.setStyle(this.node, style);
    }

    public List<AttributeValue> getAttributes() {
        return this.inflater.getAttributes(this.viewObj, this.layoutParamsObj, this.node);
    }

    public String getViewID() {
        return this.inflater.getViewID(this.node);
    }

    public void setViewID(String id) {
        this.inflater.setViewID(this.node, id);
    }

    public void setIDAttribute(@NonNull AttributeValue attribute, XmlLayoutEditView otherView, String id) {
        this.inflater.setIDAttribute(this.node, attribute.property, otherView == null ? null : otherView.node, id);
    }

    public String suggestViewID() {
        return this.inflater.suggestViewID(this.node);
    }

    public List<String> getAllIDs() {
        return this.inflater.getAllIDs();
    }

    public boolean canAddInside() {
        return canHaveChilds();
    }

    private boolean canHaveChilds() {
        return this.viewObj != null && (this.viewObj.obj instanceof ViewGroup) && !(this.viewObj.obj instanceof AdapterView);
    }

    public XmlLayoutEditView getParentView() {
        return this.parent;
    }

    public boolean isRootView() {
        return this.node.getParentNode() instanceof Document;
    }

    public boolean isRelativeLayout() {
        return this.viewObj != null && (this.viewObj.obj instanceof RelativeLayout);
    }

    public void setAttribute(@NonNull AttributeValue attribute, String value) {
        this.inflater.setAttribute(this.node, attribute.property, value);
    }

    public void addViewInside(NewWidget widget) {
        this.inflater.addViewInside(this.node, widget);
    }

    public void surroundWithView(NewWidget widget) {
        this.inflater.surroundWithView(this.node, widget);
    }

    public void addViewBehind(NewWidget widget) {
        if (getParentView().isRelativeLayout()) {
            addView(widget, XmlLayoutProperties.LAYOUT_TORIGHTOF);
        } else {
            this.inflater.addViewBehind(this.node, widget);
        }
    }

    private void addView(NewWidget widget, XmlLayoutProperties.PropertySpec layoutProperty) {
        String id = getViewID();
        if (id == null) {
            id = suggestViewID();
        }
        this.inflater.addViewInside(getParentView().node, widget, this.node, layoutProperty, id);
    }

    public void addViewBefore(NewWidget widget) {
        if (getParentView().isRelativeLayout()) {
            addView(widget, XmlLayoutProperties.LAYOUT_TOLEFTOF);
        } else {
            this.inflater.addViewBefore(this.node, widget);
        }
    }

    public void addViewAbove(NewWidget widget) {
        addView(widget, XmlLayoutProperties.LAYOUT_ABOVE);
    }

    public void addViewBelow(NewWidget widget) {
        addView(widget, XmlLayoutProperties.LAYOUT_BELOW);
    }

    public boolean canAddAbove() {
        return !isRootView() && getParentView().isRelativeLayout();
    }

    public boolean canAddBelow() {
        return !isRootView() && getParentView().isRelativeLayout();
    }

    public boolean canAddBefore() {
        return !isRootView();
    }

    public boolean canAddBehind() {
        return !isRootView();
    }

    public void delete() {
        this.inflater.deleteView(this.node);
    }

    public void gotoSourceCode(@NonNull XmlLayoutDesignActivity activity) {
        activity.gotoSourceCode(getSourceLine(), getSourceColumn());
    }

    public String getPath() {
        if (this.parent != null) {
            return this.parent.getPath() + " > " + getNodeName();
        }
        return getNodeName();
    }

    public int getDepth() {
        return this.depth;
    }

    public void startSelectingOtherView(ValueRunnable<XmlLayoutEditView> ok) {
        this.inflater.startSelectingOtherView(this.node, ok);
    }
}