package by.it.busel.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern patternStringSeparator = Pattern.compile(".+\\n*");
        Matcher matcherStringSeparator = patternStringSeparator.matcher(text);
        StringBuilder[] sbArray = new StringBuilder[coincidenceFinder(matcherStringSeparator)];
        arrayFiller(sbArray, matcherStringSeparator);
        arrayModifier(sbArray);

    }

    /**
     * A method that aligns a text with both left and right;
     *
     * @param array is an array that contains a text to be aligned;
     */
    private static void arrayModifier(StringBuilder[] array) {
        int maxRowLength = maximumElementLengthFinder(array);
        Pattern patternWordFinder = Pattern.compile("[А-ЯЁа-яё,.:!]+|[-]");
        Matcher matcherWordFinder = patternWordFinder.matcher(array[0]);
        for (int i = 0; i < array.length; i++) {
            boolean rowHitMaxRowLength = false;
            matcherWordFinder.reset(array[i]);
            int x = coincidenceFinder(matcherWordFinder);
            if (i != array.length - 1) {
                while (!rowHitMaxRowLength) {
                    for (int j = 0; j < x - 1; j++) {
                        if (array[i].length() != maxRowLength) {
                            if (matcherWordFinder.find()) {
//                                System.out.println(matcherWordFinder.group());
                                array[i].insert(matcherWordFinder.end(), " ");
//                                System.out.println(sbArray[i]);
                            }
                        } else {
                            rowHitMaxRowLength = true;
                            break;
                        }
                    }
                    matcherWordFinder.reset();
                }
            } else {
                while (!rowHitMaxRowLength) {
                    for (int j = 0; j < x - 1; j++) {
                        if (array[i].length() != maxRowLength - 1) {
                            if (matcherWordFinder.find()) {
//                                System.out.println(matcherWordFinder.group());
                                array[i].insert(matcherWordFinder.end(), " ");
//                                System.out.println(sbArray[i]);
                            }
                        } else {
                            rowHitMaxRowLength = true;
                            break;
                        }
                    }
                    matcherWordFinder.reset();
                }
            }

        }

        for (StringBuilder row : array) {
            System.out.print(row);
        }
    }

    /**
     * A method that finds a length-value of a row, which contains a maximum number of symbols
     * among another rows;
     *
     * @param array is an array that contains text;
     * @return a length-value of a row, which contains a maximum number of symbols among another rows;
     */
    private static int maximumElementLengthFinder(StringBuilder[] array) {
        int max = 0;
        for (StringBuilder element : array) {
            if (element.length() > max) {
                max = element.length();
            }
        }
        return max;
    }

    /**
     * A method that fills an array with a text, each element of which if a row of a text;
     * @param arrayToFill an array that is to be filled;
     * @param matcher is a criteria according to which "arrayToFill" is being filled;
     */
    private static void arrayFiller(StringBuilder[] arrayToFill, Matcher matcher) {
        int arrayIndex = 0;
        while (matcher.find()) {
            arrayToFill[arrayIndex++] = new StringBuilder(matcher.group());
        }
        matcher.reset();
    }

    /**
     * A method, which finds and counts a coincidence found by "matcher";
     * @param matcher is a criteria of search;
     * @return a number of coincidences found by "matcher";
     */
    private static int coincidenceFinder(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            ++counter;
        }
        matcher.reset();
        return counter;
    }

}
