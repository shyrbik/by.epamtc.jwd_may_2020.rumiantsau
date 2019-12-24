package by.it.filipovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()) {
            String word = matcher.group();
            boolean b = wordFinder(word);
            if (b)
                System.out.println(word);
        }
    }

    private static boolean wordFinder(String word) {
        String vowel = "уеыаоэяиюёЁУЕЫАОЭЯИЮ";
        char firstElem = word.charAt(0);
        char lastElem = word.charAt(word.length()-1);
        int indexOfFirst = vowel.indexOf(firstElem);
        int indexOfLast = vowel.indexOf(lastElem);
        return indexOfFirst < 0 && indexOfLast >= 0 && word.length() > 1;
    }
}
