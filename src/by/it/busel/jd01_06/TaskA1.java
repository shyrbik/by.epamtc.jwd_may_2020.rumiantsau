package by.it.busel.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ0]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int temp = matcher.start();
            text.setCharAt(temp + 3, '#');
            if (matcher.end() - matcher.start() >= 7) {
                text.setCharAt(temp + 6, '#');
            }
        }
        System.out.println(text);
    }
}
