package by.it.busel.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        // in order to change all figures and their combinations with blank spaces, besides the figures used
        // ar the end of a sentence;
        Pattern pattern = Pattern.compile("[.]{3} ?|[^а-яА-ЯёЁ.!?]+");
        Matcher matcher = pattern.matcher(text);
        String textString = matcher.replaceAll(" ");
        // in order to separate all sentences where each sentence is a separate element of an array;
        Pattern patternN = Pattern.compile("[.!?] *");
        // An array of Strings in which each element is a separate sentence;
        String[] strings = patternN.split(textString);
        // Each element contains a length of each element of "strings";
        int[] length = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            length[i] = strings[i].length();
        }
        // In order to verify whether an element of "strings" is printed;
        boolean[] alreadyPrinted = new boolean[strings.length];
        // In order to receive an order of elements of "strings" according to which
        Arrays.sort(length);
        // A loop to print elements of "strings" in a ascending order according to a length of a sentence;
        for (int value : length) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].length() == value && !alreadyPrinted[j]) {
                    alreadyPrinted[j] = true;
                    System.out.println(strings[j]);
                }
            }
        }
        // I know that it is possible to sort this sentences (strings-elements) with quicksort(),
        // but there is few sentences in Poem.text;
    }
}
