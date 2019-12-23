package by.it.lozouski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static int[] count = {};
    private static String[] words = {};

    private static int position(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern ptr = Pattern.compile("[а-яА-яёЁ]+");
        Matcher mth = ptr.matcher(Poem.text);
        while (mth.find()) {
            String word = mth.group();
            int pos = position(word);
            if (pos >= 0) {
                count[pos]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;
            }
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]+"="+count[i]);
            }
        }
    }
}
