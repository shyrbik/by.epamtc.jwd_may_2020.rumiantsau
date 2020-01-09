package by.it.filipovich.jd01_03;

public class Helper {
    /**
     *
     * @param result передаваемый в метод массив типа double
     * @return возвращает минимальный элемент массива
     */
    static double findMin(double[] result) {
        double min = Double.MAX_VALUE;
        for (double element : result) {
            if(element<min)
                min = element;
        }
        return min;
    }

    /**
     *
     * @param result передаваемый в метод массив
     * @return возвращает значение максимального элемента
     */
    static double findMax(double[] result) {
        double max = Double.MIN_VALUE;
        for (double element : result) {
            if(element > max)
                max = element;
        }
        return max;
    }

    /**
     *
     * @param arr передаваемый массив для сортировки
     */
    static void sort(double[] arr) {
        double temp;
        int iter = arr.length - 1;
        while (iter > 0) {
            for (int i = 0; i < iter; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            iter--;
        }
        InOut.printArray(arr);
    }

    /**
     *
     * @param matrix передаваемый в метод двумерный массив
     * @param vector передаваемый в метод массив-вектор
     * @return возвращает результат перемножения матриц(вектор)
     */
    static double[] mul(double[][]  matrix, double[] vector) {
        double[] matrVec = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                matrVec[i] = matrVec[i]+matrix[i][j]*vector[j];
            }
        }
        return matrVec;
    }

    /**
     *
     * @param matrixLeft передаваемый в метод двумерный массив
     * @param matrixRight передаваемый в метод второй двумерный массив
     * @return возвращает результат перемножения двух матриц (матрицу)
     */
    static double[][] mul(double[][]  matrixLeft, double[][] matrixRight) {
        double[][] matrMat = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for(int k=0;k<matrixLeft[0].length;k++) {
                    matrMat[i][j] = matrMat[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrMat;
    }
}
