package by.it.shpakovskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            int start = matcher.start();
            stringBuilder.setCharAt(start + 3, '#');
            if (matcher.group().length() >= 7) stringBuilder.setCharAt(start + 6, '#');
            System.out.println(stringBuilder.toString());

        }
    }
}
