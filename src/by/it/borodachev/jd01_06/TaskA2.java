package by.it.borodachev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static void main(String[] args) {
        String txt = new String(Poem.text);
        String[] words = txt.split("[ ,.:\n-{1,}]");
        int[] wordsCount = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >0) {
                wordsCount[i] = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        words[j] = "";
                        wordsCount[i]++;
                    }
                }

            }
        }
        for (int i = 0; (i < words.length); i++) {
            if (words[i].length()>0) {
                System.out.printf("%s=%-3d%n", words[i], wordsCount[i]);
            }
        }

    }
}

