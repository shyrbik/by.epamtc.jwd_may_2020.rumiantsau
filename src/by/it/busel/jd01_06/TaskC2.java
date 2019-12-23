package by.it.busel.jd01_06;

import java.util.Random;

public class TaskC2 {

    public static void main(String[] args) {
        long startTimeOfMethodSlow = System.nanoTime();
        String textByMethodSlow = slow(Poem.text);
        long estimatedTimeOfMethodSlow = (System.nanoTime() - startTimeOfMethodSlow) / 1000000;
        System.out.println(textByMethodSlow);
        System.out.println(estimatedTimeOfMethodSlow);
        long statTimeOfMethodFast = System.nanoTime();
        String textByMethodFast = fast(Poem.text);
        long estimatedTimeOfMethodFast = (System.nanoTime() - statTimeOfMethodFast) / 1000000;
        System.out.println(textByMethodFast);
        System.out.println(estimatedTimeOfMethodFast);
        System.out.println(textByMethodFast.equals(textByMethodSlow));

    }

    /**
     * A method that forms a String, which is more than 100K symbols, by the means of String concatenation;
     * @param text an initial String from which words are being taken;
     * @return a newly-formed String, which is more than 100K symbols, according to a statement of TaskC2;
     */
    private static String slow(String text) {
        String[] textArray = text.split("[^А-Яа-яЁё]+");
        Random random = new Random(1);
        String textNew = "";
        boolean textNewHits100K = false;
        while (!textNewHits100K) {
            if (textNew.length() < 100000) {
                textNew = textNew + textArray[random.nextInt(textArray.length)] + " ";
            } else {
                textNewHits100K = true;
            }

        }
        return textNew;
    }

    /**
     * A method that forms a String, which is more than 100K symbols, by the means of StringBuilder;
     * @param text an initial String from which words are being taken;
     * @return a newly-formed String, which is more than 100K symbols, according to a statement of TaskC2;
     */
    private static String fast(String text) {
        String[] textArray = text.split("[^А-Яа-яЁё]+");
        Random random = new Random(1);
        StringBuilder textNew = new StringBuilder("");
        boolean textNewHits100K = false;
        while (!textNewHits100K) {
            if (textNew.length() < 100000) {
                textNew.append(textArray[random.nextInt(textArray.length)]);
                textNew.append(' ');
            } else {
                textNewHits100K = true;
            }
        }
        return new String(textNew);
    }
}
