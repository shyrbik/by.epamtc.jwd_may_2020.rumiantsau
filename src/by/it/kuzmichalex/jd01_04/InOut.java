package by.it.kuzmichalex.jd01_04;

/**
 * @author kuzmichalex
 * @version 1.0
 */
public class InOut {
    /**
     * Преобразование строки разедёлнных пробелами чисел в массив double
     * @param line строка с числами, разелёнными пробелом "111 222 333". Допускаются пробелы перед первым и после последнего числа
     * @return массив double, полученный из переданной в параметрах строки
     */
     static double[] getArray(String line) {

        String[] splittedLines = line.trim().split(" ");
        double[] outArr = new double[splittedLines.length];
        for (int i = 0; i < splittedLines.length; i++) {
            outArr[i] = Double.parseDouble(splittedLines[i]);
        }
        return outArr;
    }

    /***
     * Вывод елементов массива double через пробел в одну строку. Используется print
     * @param inArr массив double который будет выведен на экран через пробелы в одну строку
     */
    public static void printArray(double[] inArr) {
        for (double v : inArr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     * Вывод элементов массива с применением printf c указанием имени элемента массива
     * Вывод производится по строкам с указанным количеством колонок
     *
     * @param inArr       массив, который надо вывести
     * @param name        имя, которе будет выводиться перед каждым элементом массива
     * @param columnCount Количество элементов массива, которые будут выведены в одну строку. т.е количество колонок.
     */
     static void printArray(double[] inArr, String name, int columnCount) {
        for (int i = 0; i < inArr.length; i++) {
            System.out.printf("%s[%d]=%f ", name, i, inArr[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        if ((inArr.length % columnCount != 0) && (columnCount > 1)) {
            System.out.println();
        }
    }
}
