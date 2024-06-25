package com.mcal.uidesigner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mcal.uidesigner.common.ColorPickerDialog;
import com.mcal.uidesigner.common.MessageBox;
import com.mcal.uidesigner.common.SizePickerDialog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class XmlLayoutPropertyEditor {
    public static final int PICK_IMAGE_REQUEST_CODE = 3424345;
    private static AttributeValue pickImageAttribute;
    private static XmlLayoutEditView pickImageEditView;

    public static void addImageFromPicker(Activity activity, final Intent data) {
        if (pickImageEditView != null) {
            MessageBox.queryText(activity, activity.getString(R.string.choose_name), activity.getString(R.string.enter_name_for_image), pickImageEditView.suggestUserDrawableName(), t -> {
                XmlLayoutPropertyEditor.pickImageEditView.addUserDrawable(t, data);
                XmlLayoutPropertyEditor.pickImageEditView.setAttribute(XmlLayoutPropertyEditor.pickImageAttribute, "@drawable/" + t);
                XmlLayoutPropertyEditor.pickImageEditView = null;
                XmlLayoutPropertyEditor.pickImageAttribute = null;
            });
        }
    }

    public static void queryValue(Activity activity, XmlLayoutEditView editView, @NonNull AttributeValue attribute) {
        final XmlLayoutProperties.PropertyType type = attribute.property.type;
        if (type == XmlLayoutProperties.PropertyType.Drawable) {
            queryDrawable(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.DrawableResource) {
            queryDrawableResource(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.Color) {
            queryColor(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.Float) {
            queryTextValue(activity, editView, attribute, "1.0");
        } else if (type == XmlLayoutProperties.PropertyType.Int) {
            queryTextValue(activity, editView, attribute, "1");
        } else if (type == XmlLayoutProperties.PropertyType.TextSize) {
            querySize(activity, editView, attribute, attribute.value, "10sp");
        } else if (type == XmlLayoutProperties.PropertyType.Size || type == XmlLayoutProperties.PropertyType.FloatSize) {
            querySize(activity, editView, attribute, attribute.value, "10dp");
        } else if (type == XmlLayoutProperties.PropertyType.LayoutSize) {
            queryLayoutSize(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.Bool) {
            queryBoolean(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.Text || type == XmlLayoutProperties.PropertyType.Event) {
            queryTextValue(activity, editView, attribute, "");
        } else if (type == XmlLayoutProperties.PropertyType.EnumConstant) {
            queryEnumValue(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.IntConstant) {
            queryIntConstantValue(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.ID) {
            queryID(activity, editView, attribute);
        } else if (type == XmlLayoutProperties.PropertyType.TextAppearance) {
            queryTextAppearance(activity, editView, attribute);
        } else {
            queryTextValue(activity, editView, attribute, "");
        }
    }

    private static void queryTextAppearance(Activity activity, XmlLayoutEditView editView, AttributeValue attribute) {
        queryFromListOrOther(activity, editView, attribute, "?android:attr/", "?android:attr/textAppearanceSmall", "?android:attr/textAppearanceMedium", "?android:attr/textAppearanceLarge");
    }

    private static void queryID(final Activity activity, final XmlLayoutEditView editView, @NonNull final AttributeValue attribute) {
        if (attribute.value == null) {
            startSelectingOtherView(activity, editView, attribute);
        } else {
            MessageBox.queryFromList(activity, attribute.property.getDisplayName(), Arrays.asList(activity.getString(R.string.view_), "none"), t -> {
                if (t.equals(activity.getString(R.string.view_))) {
                    XmlLayoutPropertyEditor.startSelectingOtherView(activity, editView, attribute);
                } else if (t.equals("id...")) {
                    List<String> values = new ArrayList<>(editView.getAllIDs());
                    Collections.sort(values);
                    MessageBox.queryFromList(activity, attribute.property.getDisplayName(), values, t2 -> editView.setIDAttribute(attribute, null, t2));
                } else {
                    editView.setAttribute(attribute, null);
                }
            });
        }
    }

    @SuppressLint("WrongConstant")
    public static void startSelectingOtherView(final Activity activity, @NonNull final XmlLayoutEditView editView, final AttributeValue attribute) {
        Toast.makeText(activity, R.string.select_another_view, Toast.LENGTH_SHORT).show();
        editView.startSelectingOtherView(otherView -> {
            if (otherView.getViewID() == null) {
                editView.setIDAttribute(attribute, otherView, otherView.suggestViewID());
            } else {
                editView.setIDAttribute(attribute, null, otherView.getViewID());
            }
            Toast.makeText(activity, activity.getString(R.string.view_was_selected_for_attribute) + attribute.property.getDisplayName(), Toast.LENGTH_SHORT).show();
        });
    }

    private static void queryIntConstantValue(Activity activity, XmlLayoutEditView editView, @NonNull AttributeValue attribute) {
        if ("android:visibility".equals(attribute.property.attrName)) {
            querySingleValue(activity, editView, attribute, "visible", "invisible", "gone");
        } else if ("android:orientation".equals(attribute.property.attrName)) {
            querySingleValue(activity, editView, attribute, "horizontal", "vertical");
        } else if ("android:typeface".equals(attribute.property.attrName)) {
            querySingleValue(activity, editView, attribute, "normal", "sans", "serif", "monospace");
        } else if ("android:alignmentMode".equals(attribute.property.attrName)) {
            querySingleValue(activity, editView, attribute, "alignBounds", "alignMargins");
        } else if ("android:textAlignment".equals(attribute.property.attrName)) {
            querySingleValue(activity, editView, attribute, "inherit", "gravity", "textStart", "textEnd", "center", "viewStart", "viewEnd");
        } else if ("android.view.Gravity".equals(attribute.property.constantClassName)) {
            queryMultipleValues(activity, editView, attribute, "top", "bottom", "left", "right", "center", "center_vertical", "center_horizontal", "fill", "fill_vertical", "fill_horizontal", "clip_vertical", "clip_horizontal", "start", "end");
        } else if (attribute.property.constantFieldPrefix == null || attribute.property.setterProxyClass == null) {
            queryTextValue(activity, editView, attribute, "");
        } else {
            List<String> values = new ArrayList<>();
            for (Field field : attribute.property.constantClass.getFields()) {
                String fieldName = field.getName();
                if ((field.getModifiers() & 8) != 0 && fieldName.startsWith(attribute.property.constantFieldPrefix)) {
                    values.add(fieldName.substring(attribute.property.constantFieldPrefix.length()).replace("_", ""));
                }
            }
            Collections.sort(values);
            queryMultipleValues(activity, editView, attribute, values);
        }
    }

    private static void queryMultipleValues(Activity activity, XmlLayoutEditView editView, AttributeValue attribute, @NonNull List<String> values) {
        queryMultipleValues(activity, editView, attribute, values.toArray(new String[values.size()]));
    }

    private static void queryMultipleValues(Activity activity, final XmlLayoutEditView editView, final AttributeValue attribute, @NonNull String... values) {
        ArrayList<String> displayValues = new ArrayList<>();
        for (String value : values) {
            displayValues.add(AttributeValue.getDisplayValue(value));
        }
        MessageBox.queryMultipleValues(activity, attribute.property.getDisplayName(), Arrays.asList(values), displayValues, attribute.value, value2 -> editView.setAttribute(attribute, value2));
    }

    private static void queryEnumValue(Activity activity, XmlLayoutEditView editView, @NonNull AttributeValue attribute) {
        if ("android.widget.ImageView$ScaleType".equals(attribute.property.constantClassName)) {
            querySingleValue(activity, editView, attribute, "matrix", "fitXY", "fitStart", "fitCenter", "fitEnd", "center", "centerCrop", "centerInside");
        } else if ("android.text.TextUtils$TruncateAt".equals(attribute.property.constantClassName)) {
            querySingleValue(activity, editView, attribute, "start", "middle", "end", "marquee");
        } else {
            queryTextValue(activity, editView, attribute, "");
        }
    }

    private static void querySingleValue(Activity activity, final XmlLayoutEditView editView, final AttributeValue attribute, @NonNull final String... values) {
        final ArrayList<String> listValues = new ArrayList<>();
        for (String value : values) {
            listValues.add(AttributeValue.getDisplayValue(value));
        }
        listValues.add("none");
        MessageBox.queryIndexFromList(activity, attribute.property.getDisplayName(), listValues, i -> {
            if (listValues.get(i).equals("none")) {
                editView.setAttribute(attribute, null);
            } else {
                editView.setAttribute(attribute, values[i]);
            }
        });
    }

    private static void queryDrawable(final Activity activity, final XmlLayoutEditView editView, @NonNull final AttributeValue attribute) {
        if (attribute.value == null) {
            MessageBox.queryFromList(activity, attribute.property.getDisplayName(), Arrays.asList(activity.getString(R.string.color_), activity.getString(R.string.drawable_), "none"), t -> {
                if (t.equals(activity.getString(R.string.color_))) {
                    XmlLayoutPropertyEditor.queryColor(activity, editView, attribute);
                } else if (t.equals(activity.getString(R.string.drawable_))) {
                    XmlLayoutPropertyEditor.queryDrawableResource(activity, editView, attribute);
                } else {
                    editView.setAttribute(attribute, null);
                }
            });
        } else if (attribute.value.startsWith("#")) {
            queryColor(activity, editView, attribute);
        } else {
            queryDrawableResource(activity, editView, attribute);
        }
    }


    public static void queryImageFromPicker(@NonNull Activity activity, XmlLayoutEditView editView, AttributeValue attribute) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        activity.startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
        pickImageEditView = editView;
        pickImageAttribute = attribute;
    }

    public static void queryDrawableResource(final Activity activity, @NonNull final XmlLayoutEditView editView, final AttributeValue attribute) {
        final ArrayList<String> values = new ArrayList<>(editView.getAllUserDrawables());
        Collections.sort(values);
        final List<String> listValues = new ArrayList<>();
        for (String s : values) {
            listValues.add(AttributeValue.getDisplayValue(s));
        }
        listValues.add(activity.getString(R.string.other_));
        listValues.add(activity.getString(R.string.add__));
        listValues.add("none");
        MessageBox.queryIndexFromList(activity, attribute.property.getDisplayName(), listValues, i -> {
            String t = listValues.get(i);
            if (t.equals("none")) {
                editView.setAttribute(attribute, null);
            } else if (t.equals(activity.getString(R.string.other_))) {
                XmlLayoutPropertyEditor.queryTextValue(activity, editView, attribute, "@drawable/");
            } else if (t.equals(activity.getString(R.string.add__))) {
                XmlLayoutPropertyEditor.queryImageFromPicker(activity, editView, attribute);
            } else {
                editView.setAttribute(attribute, values.get(i));
            }
        });
    }

    private static void queryFromListOrOther(Activity activity, XmlLayoutEditView editView, AttributeValue attribute, String prefix, String... values) {
        queryFromListOrOther(activity, editView, attribute, prefix, Arrays.asList(values));
    }

    private static void queryFromListOrOther(final Activity activity, final XmlLayoutEditView editView, final AttributeValue attribute, final String defaultValue, List<String> values) {
        final ArrayList<String> values2 = new ArrayList<>(values);
        Collections.sort(values2);
        final List<String> listValues = new ArrayList<>();
        for (String s : values2) {
            listValues.add(AttributeValue.getDisplayValue(s));
        }
        listValues.add(activity.getString(R.string.other_));
        listValues.add("none");
        MessageBox.queryIndexFromList(activity, attribute.property.getDisplayName(), listValues, i1 -> {
            String t = listValues.get(i1);
            if (t.equals("none")) {
                editView.setAttribute(attribute, null);
            } else if (t.equals(activity.getString(R.string.other_))) {
                XmlLayoutPropertyEditor.queryTextValue(activity, editView, attribute, defaultValue);
            } else {
                editView.setAttribute(attribute, values2.get(i1));
            }
        });
    }


    public static void queryColor(Activity activity, final XmlLayoutEditView editView, @NonNull final AttributeValue attribute) {
        MessageBox.showDialog(activity, new ColorPickerDialog(attribute.property.getDisplayName(), attribute.value, (color, hexColor) -> editView.setAttribute(attribute, hexColor)));
    }

    private static void queryBoolean(Activity activity, XmlLayoutEditView editView, AttributeValue attribute) {
        querySingleValue(activity, editView, attribute, "true", "false");
    }

    private static void queryLayoutSize(final Activity activity, final XmlLayoutEditView editView, @NonNull final AttributeValue attribute) {
        MessageBox.queryFromList(activity, attribute.property.getDisplayName(), Arrays.asList("Wrap Content", "Match Parent", activity.getString(R.string.fixed_size_)), t -> {
            if (t.equals("Wrap Content")) {
                editView.setAttribute(attribute, "wrap_content");
            } else if (t.equals("Match Parent")) {
                editView.setAttribute(attribute, "match_parent");
            } else {
                String v = "10dp";
                if (!"match_parent".equals(attribute.value) && !"wrap_content".equals(attribute.value)) {
                    v = attribute.value;
                }
                XmlLayoutPropertyEditor.querySize(activity, editView, attribute, v, "10dp");
            }
        });
    }


    public static void querySize(Activity activity, final XmlLayoutEditView editView, final AttributeValue attribute, String attributeValue, String defaultValue) {
        String v = attributeValue;
        if (v == null) {
            v = defaultValue;
        }
        MessageBox.showDialog(activity, new SizePickerDialog(attribute.property.getDisplayName(), v, t -> {
            if (t.length() == 0) {
                t = null;
            }
            editView.setAttribute(attribute, t);
        }, () -> editView.setAttribute(attribute, null)));
    }


    public static void queryTextValue(Activity activity, final XmlLayoutEditView editView, @NonNull final AttributeValue attribute, String defaultValue) {
        String v = attribute.value;
        if (v == null) {
            v = defaultValue;
        }
        MessageBox.queryText(activity, attribute.property.getDisplayName(), null, "None", v, t -> {
            if (t.length() == 0) {
                t = null;
            }
            editView.setAttribute(attribute, t);
        }, () -> editView.setAttribute(attribute, null));
    }

    public static void queryStyle(@NonNull final Activity activity, @NonNull final XmlLayoutEditView editView) {
        List<String> styles = new ArrayList<>(editView.getAllUserStyles());
        Collections.sort(styles);
        styles.add(activity.getString(R.string.other_));
        styles.add("none");
        MessageBox.queryFromList(activity, "Style", styles, t -> {
            if (t.equals("none")) {
                editView.setStyle(null);
            }
            if (t.equals(activity.getString(R.string.other_))) {
                MessageBox.queryText(activity, "Style", null, "None", editView.getStyle(), t2 -> {
                    if (t2.length() == 0) {
                        editView.setStyle(null);
                    } else {
                        editView.setStyle(t2);
                    }
                }, () -> editView.setStyle(null));
            } else {
                editView.setStyle(t);
            }
        });
    }

    public static void queryID(Activity activity, @NonNull final XmlLayoutEditView editView) {
        String id;
        if (editView.getViewID() != null) {
            id = editView.getViewID();
        } else {
            id = editView.suggestViewID();
        }
        MessageBox.queryText(activity, "ID", null, "None", id, t -> {
            if (t.length() == 0) {
                t = null;
            }
            editView.setViewID(t);
        }, () -> editView.setViewID(null));
    }
}
