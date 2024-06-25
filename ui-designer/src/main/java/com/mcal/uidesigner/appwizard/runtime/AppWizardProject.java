package com.mcal.uidesigner.appwizard.runtime;

import androidx.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AppWizardProject {
    private static final int NO_REFRESH = 0;
    private static final int RECREATE = 1;
    private static final int REFRESH_CONTENT = 2;
    protected AppWizardActivity activity;
    protected Document document;

    public AppWizardProject(@NonNull AppWizardActivity activity) {
        this.activity = activity;
        this.document = activity.loadXml();
        if (this.document == null) {
            createApp();
        }
    }

    public void revertToVersion(Document document, int action) {
        this.document = document;
        refreshActivity(action);
    }

    public void update(int action) {
        if (this.activity.getProject() != null) {
            this.activity.saveXml(this.document, action);
            refreshActivity(action);
        }
    }

    private void refreshActivity(int action) {
        switch (action) {
            case 1:
                this.activity.recreate();
                return;
            case 2:
                this.activity.refreshContent();
                return;
            default:
                return;
        }
    }

    public String getElementAttribute(@NonNull Element element, String attr) {
        String value = element.getAttribute(attr);
        if (value == null || value.length() <= 0) {
            return null;
        }
        return value;
    }

    public void setBooleanAttribute(Element element, String attr, Boolean b) {
        if (b == null) {
            element.setAttribute(attr, null);
        } else {
            element.setAttribute(attr, Boolean.toString(b.booleanValue()));
        }
    }

    public Boolean getBooleanElementAttribute(Element element, String attr) {
        String v = getElementAttribute(element, attr);
        if (v == null) {
            return null;
        }
        return "true".equals(v);
    }

    public void createApp() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            this.document.appendChild(this.document.createElement("app"));
            update(1);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        AppActivity act = getApp().addActivity();
        act.addFragment();
        act.addFragment();
        act.addFragment();
    }

    public AppActivity getMainActivity() {
        return getApp().getMainActivity();
    }

    public App getApp() {
        return new App((Element) this.document.getElementsByTagName("app").item(0));
    }

    public enum NavigationType {
        Single("Single Section"),
        Drawer("Single Section with Drawer"),
        Slider("Scrollable Tabs"),
        SliderDrawer("Scrollable Tabs with Drawer"),
        Tabs("Fixed Tabs"),
        TabsDrawer("Fixed Tabs with Drawer"),
        Spinner("Dropdown List"),
        SpinnerDrawer("Dropdown List with Drawer");

        public String name;

        NavigationType(String name) {
            this.name = name;
        }

        public static NavigationType forName(String name) {
            NavigationType[] arr$ = values();
            for (NavigationType type : arr$) {
                if (type.name.equals(name)) {
                    return type;
                }
            }
            return Single;
        }

        @NonNull
        public static List<String> getPossibleNames() {
            List<String> names = new ArrayList<>();
            for (NavigationType type : values()) {
                names.add(type.name);
            }
            return names;
        }

        public boolean hasDrawer() {
            switch (this) {
                case SliderDrawer:
                case SpinnerDrawer:
                case TabsDrawer:
                case Drawer:
                    return true;
                default:
                    return false;
            }
        }

        public boolean showTitleByDefault() {
            switch (this) {
                case SpinnerDrawer:
                case Spinner:
                    return false;
                case TabsDrawer:
                case Drawer:
                default:
                    return true;
            }
        }
    }

    public enum Theme {
        HoloDark("Holo Dark"),
        HoloLight("Holo Light"),
        HoloLightHoloActionBar("Holo Light Holo ActionBar"),
        HoloLightDarkActionBar("Holo Light Dark ActionBar"),
        DeviceDefault("Device Default Dark"),
        DeviceDefaultLight("Device Default Light"),
        DeviceDefaultLightDarkActionBar("Device Default Light Dark ActionBar");

        public final String name;

        Theme(String name) {
            this.name = name;
        }

        public static Theme forName(String name) {
            Theme[] arr$ = values();
            for (Theme theme : arr$) {
                if (theme.name.equals(name)) {
                    return theme;
                }
            }
            return HoloLightDarkActionBar;
        }

        @NonNull
        public static List<String> getPossibleNames() {
            List<String> names = new ArrayList<>();
            for (Theme theme : values()) {
                names.add(theme.name);
            }
            return names;
        }
    }

    public class App {
        private final Element element;

        public App(Element element) {

            this.element = element;
        }

        public AppActivity addActivity() {
            Node childElement = this.element.appendChild(document.createElement("activity"));
            update(1);
            return new AppActivity((Element) childElement);
        }

        public AppActivity getMainActivity() {
            return new AppActivity((Element) document.getElementsByTagName("activity").item(0));
        }
    }

    public class AppActivity {
        private final Element element;

        public AppActivity(Element element) {

            this.element = element;
        }

        public Theme getTheme() {
            String value = getElementAttribute(this.element, "theme");
            if (value != null) {
                return Theme.valueOf(value);
            }
            return Theme.HoloLightDarkActionBar;
        }

        public void setTheme(@NonNull Theme theme) {
            this.element.setAttribute("theme", theme.name());
            AppWizardProject.this.update(1);
        }

        public NavigationType getType() {
            String value = getElementAttribute(this.element, "type");
            if (value != null) {
                return NavigationType.valueOf(value);
            }
            return NavigationType.Tabs;
        }

        public void setNavigationType(@NonNull NavigationType type) {
            this.element.setAttribute("type", type.name());
            setShowTitleAttribute(type.showTitleByDefault());
            if (type.hasDrawer() && getFragments().size() < 2) {
                addFragmentElement();
            }
            update(1);
        }

        public String getTitle() {
            String value = getElementAttribute(this.element, "title");
            return value != null ? value : "MyApp";
        }

        public void setTitle(String title) {
            this.element.setAttribute("title", title);
            update(2);
        }

        public void setShowTitle(Boolean b) {
            setShowTitleAttribute(b);
            update(2);
        }

        private void setShowTitleAttribute(Boolean b) {
            setBooleanAttribute(this.element, "showtitle", b);
        }

        public boolean showTitle() {
            return !Boolean.FALSE.equals(showTitleValue());
        }

        public Boolean showTitleValue() {
            return getBooleanElementAttribute(this.element, "showtitle");
        }

        public void setShowActionBar(Boolean b) {
            setBooleanAttribute(this.element, "showactionbar", b);
            update(2);
        }

        public boolean showActionBar() {
            return !Boolean.FALSE.equals(showActionBarValue());
        }

        public Boolean showActionBarValue() {
            return getBooleanElementAttribute(this.element, "showactionbar");
        }

        public void setShowFullscreen(Boolean b) {
            setBooleanAttribute(this.element, "fullscreen", b);
            update(1);
        }

        public boolean showFullscreen() {
            return Boolean.TRUE.equals(showFullscreenValue());
        }

        public Boolean showFullscreenValue() {
            return getBooleanElementAttribute(this.element, "fullscreen");
        }

        public AppFragment getFragment(int id) {
            return getFragments().get(id);
        }

        public List<AppFragment> getFragments() {
            List<AppFragment> sections = new ArrayList<>();
            NodeList childs = this.element.getChildNodes();
            int id = 0;
            for (int i = 0; i < childs.getLength(); i++) {
                if (childs.item(i) instanceof Element) {
                    Element childElement = (Element) childs.item(i);
                    if ("fragment".equals(childElement.getTagName())) {
                        sections.add(new AppFragment(childElement, id));
                        id++;
                    }
                }
            }
            return sections;
        }

        public AppFragment addFragment() {
            AppFragment section = addFragmentElement();
            AppWizardProject.this.update(2);
            return section;
        }

        @NonNull
        private AppFragment addFragmentElement() {
            int size = getFragments().size();
            Element childElement = document.createElement("fragment");
            this.element.appendChild(childElement);
            AppFragment section = new AppFragment(childElement, size);
            section.setTitle("Section " + (size + 1));
            return section;
        }
    }

    public class AppFragment {
        private final Element element;
        private final int id;

        public AppFragment(Element element, int id) {

            this.element = element;
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public String getLayout() {
            return AppWizardProject.this.getElementAttribute(this.element, "layout");
        }

        public void setLayoutNoRefresh(String name) {
            this.element.setAttribute("layout", name);
            AppWizardProject.this.update(0);
        }

        public AppActivity getActivity() {
            return AppWizardProject.this.getMainActivity();
        }

        public String getTitle() {
            return AppWizardProject.this.getElementAttribute(this.element, "title");
        }

        public void setTitle(String t) {
            this.element.setAttribute("title", t);
            AppWizardProject.this.update(2);
        }

        public void delete() {
            this.element.getParentNode().removeChild(this.element);
            AppWizardProject.this.update(2);
        }
    }
}
