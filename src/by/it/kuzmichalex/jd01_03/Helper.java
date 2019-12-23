package by.it.kuzmichalex.jd01_03;

public class Helper {
    /**
     * нахождение минимального значения в массиве
     *
     * @param arr - массив чисел, в котором требуется найти наименьшее
     * @return -наименьшее значение. Double.MAX_VALUE для пустого массива
     */
    static double findMin(double[] arr) {
        double retValue = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < retValue) retValue = arr[i];
        }
        return retValue;
    }

    /**
     * нахождение максимального значения в массиве
     *
     * @param arr - массив чисел, в котором требуется найти наибольшее
     * @return наибольшее значение. Double.MAX_MINVALUE для пустого массива
     */
    static double findMax(double[] arr) {
        double retValue = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > retValue) retValue = arr[i];
        }
        return retValue;
    }

    /**
     * Сортировка массива по возрастанию. Метод пузьрька. Кажется.
     *
     * @param arr массив, который надо отсортировать
     */
    static void sort(double[] arr) {
        if (arr.length < 2) return;
        for (int idxStart = 0; idxStart < arr.length - 1; idxStart++) {
            int idxSwap = idxStart;
            for (int i = idxStart; i < arr.length; i++) {
                if (arr[i] < arr[idxSwap]) idxSwap = i;
            }
            double swapValue = arr[idxSwap];
            arr[idxSwap] = arr[idxStart];
            arr[idxStart] = swapValue;
        }
    }

    /**
     * Умножение матрицы на вектор. Размерность матрицы по горизонтали должно соответствовать вектору
     *
     * @param matrix первый сомножитель - матрица
     * @param vector второй сомножитель - вектор
     * @return массив, являющийся результатом умножения матрицы на вектор. Размер массива=размеру матрицы по вертикали
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                result[y] += matrix[y][x] * vector[x];
            }
        }
        return result;
    }

    /**
     *   Умножение матриц. Кол-во столбцов левой матрицы должно соответствовать кол-ву строк правой.
     *
     * @param matrixLeft  левая матрица
     * @param matrixRight правая матрица
     * @return результат умножения матриц; массив размером строк левой матрицы и столбцов правой
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        int resultRows = matrixLeft.length;
        int resultColumns = matrixRight[0].length;
        double[][] result = new double[resultRows][resultColumns];

        for (int y = 0; y < resultRows; y++) {
            for (int x = 0; x < resultColumns; x++) {
                for (int s = 0; s < matrixLeft[0].length; s++) result[y][x] += matrixLeft[y][s] * matrixRight[s][x];
            }
        }
        return result;
    }
}
