package by.it.lozouski.jd02_05;

import java.util.Locale;

class Runner {
    public static void main(String[] args) {
        ChangeLanguageService changeLanguageService = ChangeLanguageService.START;
        if (args.length==2){
            Locale locale = new Locale(args[0],args[1]);
            changeLanguageService.setLocale(locale);
        }
        System.out.println(changeLanguageService.get(Messages.WELCOME));
        System.out.println(changeLanguageService.get(User.FIRSTNAME));
        System.out.println(changeLanguageService.get(User.LASTNAME));
        System.out.println(changeLanguageService.get(Messages.QUESTION));
    }
}
