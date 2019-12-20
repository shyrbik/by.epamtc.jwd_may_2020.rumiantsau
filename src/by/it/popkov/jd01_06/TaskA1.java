package by.it.popkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher m1 = p1.matcher(text);
        while (m1.find()){
            text.replace(m1.start()+3, m1.start()+4,"#");
            if (m1.group().length()>6){
                text.replace(m1.start()+6, m1.start()+7,"#");
            }
        }
        System.out.println(text);
    }
}
