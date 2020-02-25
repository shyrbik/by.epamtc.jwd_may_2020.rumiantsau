package by.it.popkov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class Runner {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("by.it.popkov.jd02_05.resource.hello", locale);
        System.out.println(rb.getString("user.firstName"));
    }
}
