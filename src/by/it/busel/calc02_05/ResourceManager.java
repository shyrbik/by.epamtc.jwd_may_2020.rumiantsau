package by.it.busel.calc02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class ResourcesManager {
    static private ResourceBundle resourceBundle;

    private static final String resourceBundleName = generateBundleName(".resources.errors");

    ResourcesManager() {
        resourceBundle = ResourceBundle.getBundle(resourceBundleName, Locale.getDefault());
    }

    static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceBundleName, locale);
    }

    static Locale getLocale() {
        return resourceBundle.getLocale();
    }

    static String get(String resManKey) {
        return resourceBundle.getString(resManKey);
    }

    static void informAboutCurrentLocale() {
        System.out.printf(resourceBundle.getString(Message.CURRENT_LANGUAGE),
                resourceBundle.getLocale().getDisplayLanguage());
    }

    private static String generateBundleName(String fileName) {
        return ResourcesManager.class.getPackage().getName() + fileName;
    }
}