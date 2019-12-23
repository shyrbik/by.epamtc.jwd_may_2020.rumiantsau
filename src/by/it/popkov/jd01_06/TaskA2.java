package by.it.popkov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {

        Pattern p1 = Pattern.compile("[А-Яа-яЁё]+");
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()) {
            if (!check(m1)){
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = m1.group();
                counters = Arrays.copyOf(counters, counters.length + 1);
                counters[counters.length - 1]++;
            }

        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + counters[i]);
        }
    }

    private static boolean check(Matcher m1) {
        for (int i = 0; i < words.length; i++) {
            if (m1.group().equals(words[i])) {
                counters[i]++;
                return true;
            }
        }
        return false;
    }

}
