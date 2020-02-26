package by.it.popkov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum  LangSwitcher  {
    LANG_SWITCHER;
    private ResourceBundle resourceBundle;
    private String baseName = "by.it.popkov.jd02_05.resource.hello";

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }
}
