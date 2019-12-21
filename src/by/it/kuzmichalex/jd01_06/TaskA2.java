package by.it.kuzmichalex.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Тестовое задание A2.
 * Подсчёт количества вхождений каждого слова в поэме
 */
public class TaskA2 {
    private static String[] lexicon;
    private static int[] countWordUsage;

    public static void main(String[] args) {
        lexicon = new String[0];
        countWordUsage = new int[0];
        Pattern patternRussianWord = Pattern.compile("[А-Яа-яЁё]{1,}");
        Matcher russianWord = patternRussianWord.matcher(Poem.text);
        while (russianWord.find()) {
            calcWord(russianWord.group());
        }
        for (int i = 0; i < lexicon.length; i++) {
            System.out.printf("%s=%d%n", lexicon[i], countWordUsage[i]);
        }
    }

    /**
     * Добавление слова в массив lexicon, если там его ещё нет
     * и подсчёт количества вхождений этого слова в совпадающем по индексам массиве counterWordUsed
     * @author kuzmichalex
     * @param wordToCalculate Добавляемое (подсчитываемое слово)
     */
    private static void calcWord(String wordToCalculate) {
        for (int i = 0; i < lexicon.length; i++) {
            if (lexicon[i].equals(wordToCalculate)) {
                countWordUsage[i]++;
                return;
            }
        }
        //Слово не найдено. будем добавлять
        lexicon = Arrays.copyOf(lexicon, lexicon.length + 1);
        lexicon[lexicon.length - 1] = wordToCalculate;
        countWordUsage = Arrays.copyOf(countWordUsage, countWordUsage.length + 1);
        countWordUsage[countWordUsage.length - 1] = 1;
    }
}
