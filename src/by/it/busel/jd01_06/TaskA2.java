package by.it.busel.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[А-ЯЁа-яё]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            identifier(word);
        }
        printerTaskA2();

    }

    private static void printerTaskA2() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], counters[i]);
        }
    }

    private static void identifier(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counters[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        counters = Arrays.copyOf(counters, counters.length + 1);
        counters[counters.length - 1] = 1;
    }
}
