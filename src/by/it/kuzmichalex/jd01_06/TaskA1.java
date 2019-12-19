package by.it.kuzmichalex.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Тестовое задание A1 в каждом смлове 4 и 7 заменить на диез
 * */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder poemText = new StringBuilder(Poem.text);
        Pattern patternOfRussianWord = Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher wordOfPoem = patternOfRussianWord.matcher(poemText);

        while( wordOfPoem.find()){
            int startOfWord = wordOfPoem.start();
            int endOfWord = wordOfPoem.end();
            poemText.setCharAt(startOfWord+3,'#');
            if((endOfWord-startOfWord)>6)poemText.setCharAt(startOfWord+6,'#');
        }
        System.out.println(poemText);
    }
}
