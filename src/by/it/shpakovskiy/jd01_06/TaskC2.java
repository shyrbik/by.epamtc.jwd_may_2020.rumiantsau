package by.it.shpakovskiy.jd01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long startSlow = System.currentTimeMillis();
        System.out.println(slow(Poem.text));
        long endSlow = System.currentTimeMillis();

        long startFast = System.currentTimeMillis();
        System.out.println(fast(Poem.text));
        long endFast = System.currentTimeMillis();

        long deltaSlow = (endSlow - startSlow);
        long deltaFast = (endFast - startFast);

        System.out.println("Slow = " + deltaSlow);
        System.out.println("Fast = " + deltaFast);
        System.out.println("Slow/fast = " + (deltaSlow / deltaFast));
    }

    private static String slow(String text) {
        String s = "";
        Random random = new Random(1);
        Pattern pattern = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] words = pattern.split(text);
        while (s.length() < 100000) {
            s += words[random.nextInt(words.length)] + " ";
        }
        return s;
    }

    private static String fast(String text) {
        StringBuilder s = new StringBuilder();
        Random random = new Random(1);
        Pattern pattern = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] words = pattern.split(text);
        while (s.length() < 100000) {
            s.append(words[random.nextInt(words.length)]).append(" ");
        }
        return s.toString();
    }
}