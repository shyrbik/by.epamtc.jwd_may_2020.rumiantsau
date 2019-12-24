package by.it.lozouski.jd01_03;

/**
 * В этом классе хранятся вспомогательные методы
 * для различных рассчетов и манипуляций с данными.
 *
 * @author - Lozouski Andrei
 * @version - ver 1.0-beta.
 */
class Helper {
    /**
     * В этом методе выполняется поиск минимального значения во входящем массиве
     *
     * @param arr - Входной массив.
     * @return min - Возвращает минимальное значение с типом double.
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    /**
     * В этом методе выполняется поиск максимального значения во входящем массиве
     *
     * @param arr - Входной массив.
     * @return max - Возвращает максимальное значение с типом double.
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    /**
     * В этом методе выполняется сортировка массива.
     *
     * @param mas - входящий double[] массив.
     */
    static void sort(double[] mas) {
        boolean isSorted = false;
        double buf = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
    }

    /**
     * В этом методе выполняется умножение матрицы на вектор.
     *
     * @param matrix - Входящая матрица ( double[][] matrix - двумерный массив )
     * @param vector - Входящий вектор ( double[] vector - одномерный массив )
     * @return result - Метод возвращает результат умножения матрицы на вектор в виде одномерного массива double[]
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < vector.length; i1++) {
                result[i] = result[i] + matrix[i][i1] * vector[i1];
            }
        }
        return result;
    }

    /**
     * В этом методе выполняется умножение матрицы на матрицу.
     *
     * @param matrixLeft  Входящая матрица ( double[][] matrixLeft - двумерный массив )
     * @param matrixRight Входящая матрица ( double[][] matrixRight - двумерный массив )
     * @return matrix  Метод возвращает результат умножения матрицы на матрицу в виде двумерного массива double[][]
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Вспомогательный метод для генерации матрццы double[][] matrix со случайно сгенерированными
     * значениями, в пределах от -count до count не включая само значение count.
     *
     * @param count - Входящий параметр int - предел числовых значений для генерации.
     * @return matrix - Возвращаемая методом, полученная матрица double[][]
     */
    static double[][] matrixBuilderRandom(int count) {
        double[][] matrix = new double[count][count];
        double min = -count;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < count; j++) {
                double rand = min + (Math.random() * ((count - min) + 1));
                if (rand != count && rand != min) matrix[i][j] = rand;
                else {
                    if (rand == count) matrix[i][j] = count;
                    else matrix[i][j] = min;
                    j = count;
                }
            }
        }
        return matrix;
    }
}
