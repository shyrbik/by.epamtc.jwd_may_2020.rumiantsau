package by.it.kuzmichalex.jd01_06;

import java.util.Random;

/**
 * @author kuzmichAlex
 * Тестовое зедание C2. Формирование случайного длинного текста из слов входной строки
 * двумя методами и сравнение результата этих методов
 */
public class TaskC2 {
    final static int countOfWords = 10000;
    final static int initRandomValue = 1234;

    public static void main(String[] args) {
        final String testText = "Soy un chico delicado Que nacio para el amor Esto coche me ha estopeado Para las pilas senor";
        long slowTime = System.nanoTime();
        String resultString = slow(testText);
        slowTime = System.nanoTime() - slowTime;
        System.out.println("Медленный метод: " + slowTime);

        long fastTime = System.nanoTime();
        resultString = fast(testText);
        fastTime = System.nanoTime()-fastTime;
        System.out.println("Быстрый метод: " + fastTime);
    }

    /**
     * @param inputString Строка текста, слова которого будут применяться для сосотавления случайного текста
     * @return Случайный текст.
     * @author kuzmivhalex
     * Медленная операция составления случайного текста из слов входного предложения
     */
    private static String slow(String inputString) {
        String returnString = new String();
        String[] arrWords = inputString.split(" {1,}");

        Random pseudoRandom = new Random(initRandomValue);

        for (int i = 0; i < countOfWords; i++) {
            int randomIdx = pseudoRandom.nextInt(arrWords.length);
            returnString += arrWords[randomIdx] + " ";
        }
        return returnString;
    }

    /**
     * @param inputString Строка текста, слова которого будут применяться для сосотавления случайного текста
     * @return Случайный текст.
     * @author kuzmivhalex
     * Быстрая операция составления случайного текста из слов входного предложения
     */
    private static String fast(String inputString) {
        StringBuffer returnString = new StringBuffer();
        String[] arrWords = inputString.split(" {1,}");
        Random pseudoRandom = new Random(initRandomValue);

        for (int i = 0; i < countOfWords; i++) {
            int randomIdx = pseudoRandom.nextInt(arrWords.length);
            returnString.append(arrWords[randomIdx]);
            returnString.append(" ");
        }
        return returnString.toString();
    }
}
