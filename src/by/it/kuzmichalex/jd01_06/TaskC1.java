package by.it.kuzmichalex.jd01_06;

/**
 * @author kuzmichalex
 * Задача C1. Вывод поэмы с форматированием по ширине
 */
public class TaskC1 {
    public static void main(String[] args) {
        String[] arrPoemStrings = Poem.text.split("\\n");
        int maxStringLength = 0;
        for (int i = 0; i < arrPoemStrings.length; i++) {
            if (arrPoemStrings[i].length() > maxStringLength) maxStringLength = arrPoemStrings[i].length();
        }
        for (int i = 0; i < arrPoemStrings.length; i++) {
            formatAndprintString(arrPoemStrings[i], maxStringLength);
        }

    }

    /**
     * @author kuzmichalex
     * Выравнивание строки по ширине добавлением пробелов между словами и вывод на экран
     * @param stringToFormat     Строка, которую надо отформатировать по ширине до следующегшо параметра
     * @param lengthOfStringNeed Длина строки, которая должна получиться в результате форматирования
     */
    private static void formatAndprintString(String stringToFormat, int lengthOfStringNeed) {
        String[] arrWords = stringToFormat.trim().split(" {1,}");
        int countOfDividers = arrWords.length - 1;
        int lengthOfWords = 0;
        for (int i = 0; i < arrWords.length; i++) lengthOfWords += arrWords[i].length();
        int commonLengthOfSpaces = lengthOfStringNeed - lengthOfWords;
        int constantSpaces = commonLengthOfSpaces / countOfDividers;
        int volatileSpaces = commonLengthOfSpaces % countOfDividers;
        for (int i = 0; i < countOfDividers; i++) {
            System.out.print(arrWords[i]);
            for (int j = 0; j < constantSpaces; j++) System.out.print(" ");
            if (volatileSpaces > 0) {
                System.out.print(" ");
                volatileSpaces--;
            }
        }
        System.out.println(arrWords[countOfDividers]);
    }
}

