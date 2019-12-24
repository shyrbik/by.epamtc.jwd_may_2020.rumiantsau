package by.it.lozouski.jd01_04;

/**
 * Класс для работы с вводом выводом массивов.
 * @author - Lozouski Andrei
 * @version - ver 1.0-beta.
 */
class InOut {
    /**
     * @param line - Входная строка для формирования double массива.
     * @return resArr - Возвращаемый методом double[] массив.
     */
    static double[] getArray(String line) {
        String[] strArr = line.trim().split(" ");
        double[] resArr = new double[strArr.length];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = Double.parseDouble(strArr[i]);
        }
        return resArr;
    }

    /**
     * @param arr - Входной double[] массив.
     */
    static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.printf("% -6.2f ", num);
        }
        System.out.println();
    }

    /**
     * @param arr         - Входной double[] массив.
     * @param name        - Имя массива
     * @param columnCount - Количество элементов в строке вывода массива.
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%-6.3f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) System.out.println();
        }
    }


}
