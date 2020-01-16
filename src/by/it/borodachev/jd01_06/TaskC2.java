package by.it.borodachev.jd01_06;

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

        System.out.println("Slow = " + (endSlow - startSlow));
        System.out.println("Fast = " + (endFast - startFast));
    }

    private static String fast(String text) {
        StringBuilder newStr = new StringBuilder(Poem.text);
        Pattern pat = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] wordsArray = pat.split(newStr);
        Random rnd = new Random(0);
        StringBuilder retStr = new StringBuilder();
        for (int i = 0; i < 70000; i++) {
            retStr.append(wordsArray[rnd.nextInt(wordsArray.length)]).append(" ");
        }
        return retStr.toString();
    }

    private static String slow(String text) {
        StringBuilder newStr = new StringBuilder(Poem.text);
        Pattern pat = Pattern.compile("[^а-яА-ЯёЁ]+");
        String[] wordsArray = pat.split(newStr);
        Random rnd = new Random(0);
        String retStr = "";
        for (int i = 0; i < 70000; i++) {
            retStr += wordsArray[rnd.nextInt(wordsArray.length)] + " ";
        }
        return retStr;
    }
}
