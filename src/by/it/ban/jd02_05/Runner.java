package by.it.ban.jd02_05;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan res= ResMan.INSTANCE;
        Locale locale = null;
        if (args.length==2){
            locale=new Locale(args[0],args[1]);
            res.setLocale(locale);
        }else {
            Locale.getDefault();
        }
        System.out.println(res.get(Messages.WELCOME));
        System.out.println(res.get(User.FIRST_NAME));
        System.out.println(res.get(User.LAST_NAME));
        System.out.println(res.get(Messages.QUESTION));
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
        Calendar calendar = Calendar.getInstance();
        Date moment=calendar.getTime();
        System.out.println(df.format(moment));



    }
}
