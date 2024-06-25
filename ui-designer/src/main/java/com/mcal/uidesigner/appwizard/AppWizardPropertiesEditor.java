package com.mcal.uidesigner.appwizard;

import androidx.annotation.NonNull;

import com.mcal.uidesigner.R;
import com.mcal.uidesigner.appwizard.runtime.AppWizardProject;
import com.mcal.uidesigner.common.MessageBox;
import com.mcal.uidesigner.common.PropertiesDialog;
import com.mcal.uidesigner.common.ValueRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppWizardPropertiesEditor {
    private final AppWizardDesignActivity mActivity;
    private AppWizardProject.AppFragment currentFragment;

    public AppWizardPropertiesEditor(AppWizardDesignActivity activity) {
        mActivity = activity;
    }

    public void showProperties() {
        if (currentFragment != null) {
            MessageBox.showDialog(mActivity, new PropertiesDialog("Activity \"" + mActivity.getProject().getMainActivity().getTitle() + "\" > Fragment \"" + currentFragment.getTitle() + "\"", getFragmentCommands(currentFragment)));
        } else {
            MessageBox.showDialog(mActivity, new PropertiesDialog("Activity \"" + mActivity.getProject().getMainActivity().getTitle() + "\"", getAppActivityCommands(mActivity.getProject().getMainActivity())));
        }
    }

    @NonNull
    private List<? extends PropertiesDialog.PropertyCommand> getFragmentCommands(@NonNull final AppWizardProject.AppFragment appFragment) {
        List<PropertiesDialog.PropertyCommand> cmds = new ArrayList<>();
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                currentFragment = null;
                showProperties();
            }

            @Override
            public String getName() {
                return "Activity";
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_goto;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
        if (appFragment.getActivity().getFragments().size() > 1) {
            cmds.add(new PropertiesDialog.PropertyCommand() {
                @Override
                public void run() {
                    appFragment.delete();
                    currentFragment = null;
                    showProperties();
                }

                @Override
                public String getName() {
                    return "Delete";
                }

                @Override
                public int getIconAttr() {
                    return R.attr.icon_delete;
                }

                @Override
                public String getHelpUrl() {
                    return null;
                }

                @Override
                public boolean canRun() {
                    return true;
                }
            });
        }
        addStringProperty(cmds, "Title", appFragment.getTitle(), appFragment::setTitle);
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
            }

            @Override
            public String getName() {
                return getPropertyTitle("Layout", appFragment.getLayout());
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
        return cmds;
    }

    @NonNull
    private List<? extends PropertiesDialog.PropertyCommand> getAppActivityCommands(@NonNull final AppWizardProject.AppActivity appActivity) {
        List<PropertiesDialog.PropertyCommand> cmds = new ArrayList<>();
        for (final AppWizardProject.AppFragment section : appActivity.getFragments()) {
            cmds.add(new PropertiesDialog.PropertyCommand() {
                @Override
                public void run() {
                    currentFragment = section;
                    showProperties();
                }

                @Override
                public String getName() {
                    return "Fragment &quot;<b>" + section.getTitle() + "</b>&quot;";
                }

                @Override
                public int getIconAttr() {
                    return R.attr.icon_goto;
                }

                @Override
                public String getHelpUrl() {
                    return null;
                }

                @Override
                public boolean canRun() {
                    return true;
                }
            });
        }
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                currentFragment = appActivity.addFragment();
                showProperties();
            }

            @Override
            public String getName() {
                return "Add Fragment";
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_add;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
        addStringProperty(cmds, "Title", appActivity.getTitle(), appActivity::setTitle);
        addNavigationProperty(cmds, appActivity);
        addThemeProperty(cmds, appActivity);
        addBooleanProperty(cmds, "Show Title", appActivity.showTitleValue(), appActivity::setShowTitle);
        addBooleanProperty(cmds, "Show Action Bar", appActivity.showActionBarValue(), appActivity::setShowActionBar);
        addBooleanProperty(cmds, "Fullscreen", appActivity.showFullscreenValue(), appActivity::setShowFullscreen);
        return cmds;
    }

    private void addNavigationProperty(@NonNull List<PropertiesDialog.PropertyCommand> cmds, final AppWizardProject.AppActivity app) {
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                MessageBox.queryFromList(mActivity, "Navigation", AppWizardProject.NavigationType.getPossibleNames(), t -> {
                    app.setNavigationType(AppWizardProject.NavigationType.forName(t));
                });
            }

            @Override
            public String getName() {
                return getPropertyTitle("Navigation", app.getType().name);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
    }

    private void addThemeProperty(@NonNull List<PropertiesDialog.PropertyCommand> cmds, final AppWizardProject.AppActivity app) {
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                MessageBox.queryFromList(mActivity, "Theme", AppWizardProject.Theme.getPossibleNames(), t -> {
                    app.setTheme(AppWizardProject.Theme.forName(t));
                });
            }

            @Override
            public String getName() {
                return getPropertyTitle("Theme", app.getTheme().name);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
    }

    private void addStringProperty(@NonNull List<PropertiesDialog.PropertyCommand> cmds, final String title, final String value, final ValueRunnable<String> ok) {
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                MessageBox.queryText(mActivity, title, null, value, ok);
            }

            @Override
            public String getName() {
                return getStringPropertyTitle(title, value);
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
    }

    private void addBooleanProperty(@NonNull List<PropertiesDialog.PropertyCommand> cmds, final String title, final Boolean value, final ValueRunnable<Boolean> ok) {
        cmds.add(new PropertiesDialog.PropertyCommand() {
            @Override
            public void run() {
                MessageBox.queryFromList(mActivity, title, Arrays.asList("true", "false", "none"), t -> ((ValueRunnable<String>) t2 -> {
                    if ("none".equals(t2)) {
                        ok.run(null);
                    } else if ("true".equals(t2)) {
                        ok.run(true);
                    } else {
                        ok.run(false);
                    }
                }).run(t));
            }

            @Override
            public String getName() {
                return getPropertyTitle(title, value == null ? null : Boolean.toString(value));
            }

            @Override
            public int getIconAttr() {
                return R.attr.icon_manage;
            }

            @Override
            public String getHelpUrl() {
                return null;
            }

            @Override
            public boolean canRun() {
                return true;
            }
        });
    }

    public String getStringPropertyTitle(String property, String value) {
        return value == null ? property : property + " = <b>&quot;" + value + "&quot;</b>";
    }

    public String getPropertyTitle(String property, String value) {
        return value == null ? property : property + " = <b>" + value + "</b>";
    }
}
