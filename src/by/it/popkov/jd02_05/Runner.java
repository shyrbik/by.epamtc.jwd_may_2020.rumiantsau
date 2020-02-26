package by.it.popkov.jd02_05;

import java.util.Locale;

class Runner {
    public static void main(String[] args) {
        LangSwitcher langSwitcher = LangSwitcher.LANG_SWITCHER;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            langSwitcher.setResourceBundle(locale);
        }
        System.out.println(langSwitcher.getResourceBundle().getString(Message.WELCOME));
        System.out.println(langSwitcher.getResourceBundle().getString(User.FIRST_NAME));
        System.out.println(langSwitcher.getResourceBundle().getString(User.SECOND_NAME));

    }
}
