package by.it.popkov.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {

        System.out.println(slow(Poem.text));
        long slow = System.nanoTime();
        System.out.println(slow);
        System.out.println(fast(Poem.text));
        long fast = System.nanoTime();
        System.out.println(fast);
        System.out.println("slow = " + slow + " fast = " + (fast - slow));

    }

    private static String[] textToWords(String text) {
        String[] words = new String[0];
        Pattern p = Pattern.compile("[А-Яа-яЁё]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = m.group();
        }
        return words;
    }

    private static String slow(String text) {
        String outText = "";
        String[] words = textToWords(text);
        Random rand = new Random(47);
        while (outText.length() <= 150000) {
            int r = rand.nextInt(words.length);
            outText += words[r] + " ";
        }
        return outText;
    }

    private static String fast(String text) {
        StringBuilder outText = new StringBuilder();
        String[] words = textToWords(text);
        Random rand = new Random(47);
        while (outText.length() <= 150000) {
            int r = rand.nextInt(words.length);
            outText.append(words[r]).append(" ");
        }
        return outText.toString();
    }

}
