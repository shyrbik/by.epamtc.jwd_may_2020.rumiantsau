package by.it.akhmelev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = p.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (ok(word))
                System.out.println(word);
        }

    }

    private static final String vol = "уеэоаыяиюЮИЯЭОАЫЕУёЁ";

    private static boolean ok(String word) {

        return word!=null &&
                word.length()>1 &&
                vol.indexOf(word.charAt(0)) < 0 &&
                vol.indexOf(word.charAt(word.length() - 1)) >= 0;
    }


}
