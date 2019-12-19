package by.it.popkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[[А-Я[а-я]]Ёё]{4,}");
        Matcher m1 = p1.matcher(text);
        while (m1.find()){
            System.out.println(m1.group());
        }
    }
}
