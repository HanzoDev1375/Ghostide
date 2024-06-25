package com.mcal.uidesigner;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.mcal.uidesigner.common.MessageBox;
import com.mcal.uidesigner.common.PropertiesDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlLayoutEditViewMenu {
    public static void showViewEditMenu(Activity activity, @NonNull XmlLayoutEditView editView) {
        MessageBox.showDialog(activity, new PropertiesDialog(editView.getPath(), getContextCommands(activity, editView)));
    }

    @NonNull
    private static List<PropertiesDialog.PropertyCommand> getContextCommands(Activity activity, XmlLayoutEditView editView) {
        List<PropertiesDialog.PropertyCommand> commands = new ArrayList<>();
        commands.addAll(getFixedContextCommands(activity, editView));
        commands.addAll(getPropertyCommands(activity, editView));
        return commands;
    }

    @NonNull
    private static List<PropertiesDialog.PropertyCommand> getPropertyCommands(final Activity activity, @NonNull final XmlLayoutEditView editView) {
        String name;
        List<PropertiesDialog.PropertyCommand> result = new ArrayList<>();
        for (final AttributeValue attribute : editView.getAttributes()) {
            if (attribute.isStyled()) {
                name = attribute.property.getDisplayName() + " styled <b>" + attribute.getDisplayValue() + "</b>";
            } else if (attribute.hasValue()) {
                name = attribute.property.getDisplayName() + " = <b>" + attribute.getDisplayValue() + "</b>";
            } else {
                name = attribute.property.getDisplayName();
            } 
            String finalName = name;
            result.add(new PropertiesDialog.PropertyCommand() {
                @Override
                public void run() {
                    XmlLayoutPropertyEditor.queryValue(activity, editView, attribute);
                }

                @Override
                public String getName() {
                    return finalName;
                }

                @Override
                public boolean canRun() {
                    return true;
                }

                @Override
                public int getIconAttr() {
                    return R.attr.icon_manage;
                }

                @Override
                public String getHelpUrl() {
                    return "android/R.attr.html#" + finalName;
                }
            });
        }
        return result;
    }

    @NonNull
    private static List<PropertiesDialog.PropertyCommand> getFixedContextCommands(final Activity activity, final XmlLayoutEditView editView) {
        return Arrays.asList(new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.parent_view_);
            }

            @Override
            public boolean canRun() {
                return editView.getParentView() != null;
            }

            @Override
            public void run() {
                XmlLayoutEditViewMenu.showViewEditMenu(activity, editView.getParentView());
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_goto;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }/*, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.source_code_);
            }

            @Override
            public boolean canRun() {
                return activity instanceof XmlLayoutDesignActivity;
            }

            @Override
            public void run() {
                if (activity instanceof XmlLayoutDesignActivity) {
                    editView.gotoSourceCode((XmlLayoutDesignActivity) activity);
                }
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_goto;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }*/, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.add_inside_);
            }

            @Override
            public boolean canRun() {
                return editView.canAddInside();
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectView(activity, activity.getString(R.string.add_inside) + editView.getNodeName() + "…", editView::addViewInside);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.add_above_);
            }

            @Override
            public boolean canRun() {
                return editView.canAddAbove();
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectView(activity, activity.getString(R.string.add_above) + editView.getNodeName() + "…", editView::addViewAbove);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.add_below_);
            }

            @Override
            public boolean canRun() {
                return editView.canAddBelow();
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectView(activity, activity.getString(R.string.add_below) + editView.getNodeName() + "…", editView::addViewBelow);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.add_before_);
            }

            @Override
            public boolean canRun() {
                return editView.canAddBefore();
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectView(activity, activity.getString(R.string.add_before) + editView.getNodeName() + "…", editView::addViewBefore);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.add_behind_);
            }

            @Override
            public boolean canRun() {
                return editView.canAddBehind();
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectView(activity, activity.getString(R.string.add_behind) + editView.getNodeName() + "…", editView::addViewBehind);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.surround_with_);
            }

            @Override
            public boolean canRun() {
                return true;
            }

            @Override
            public void run() {
                XmlLayoutWidgetPicker.selectSurroundView(activity, activity.getString(R.string.surround) + editView.getNodeName() + activity.getString(R.string.with_), editView::surroundWithView);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                return activity.getString(R.string.delete);
            }

            @Override
            public boolean canRun() {
                return true;
            }

            @Override
            public void run() {
                editView.delete();
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_delete;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                if (editView.getViewID() == null) {
                    return "ID";
                }
                return "ID = <b>" + editView.getViewID() + "</b>";
            }

            @Override
            public boolean canRun() {
                return true;
            }

            @Override
            public void run() {
                XmlLayoutPropertyEditor.queryID(activity, editView);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        }, new PropertiesDialog.PropertyCommand() {
            @Override
            public String getName() {
                if (editView.getStyle() == null) {
                    return "Style";
                }
                return "Style = <b>" + AttributeValue.getDisplayValue(editView.getStyle()) + "</b>";
            }

            @Override
            public boolean canRun() {
                return true;
            }

            @Override
            public void run() {
                XmlLayoutPropertyEditor.queryStyle(activity, editView);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }
        });
    }
}