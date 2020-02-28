package by.it.lozouski.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum ChangeLangService {
    START;
    private ResourceBundle resourceBundle;
    private final String resourseName = "by.it.lozouski.calc.calcTxtFiles.messages";

    ChangeLangService() {
        resourceBundle = ResourceBundle.getBundle(resourseName, Locale.getDefault());
    }

    void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourseName, locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
