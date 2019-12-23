package by.it.busel.jd01_03;

/**
 * Purposes:
 * 1) to find a maximum value from an array of doubles;
 * 2) to find a minimum value from an array of doubles;
 * 3) to sort an array of doubles in the ascending order;
 * 4) to multiply a 2-dimensional array by a vector, which is actually a 1-dimensional array;
 * 5) to multiply a 2-dimensional array by another one;
 */
class Helper {
    /**
     * a method that finds a maximum value from a received array of doubles;
     *
     * @param arr a received array of doubles;
     * @return maximum double-value;
     */
    static double findMax(double[] arr) {
        double maximum = arr[0];
        for (double element : arr) {
            if (element > maximum) {
                maximum = element;
            }
        }
        return maximum;
    }

    /**
     * a method that finds a maximum value from a received array of doubles;
     *
     * @param arr a received array of doubles;
     * @return minimum double-value
     */
    static double findMin(double[] arr) {
        double minimum = arr[0];
        for (double element : arr) {
            if (element < minimum) {
                minimum = element;
            }
        }
        return minimum;
    }

    /**
     * a method that sort a received array of doubles in the ascending order;
     *
     * @param arr an array of doubles;
     */
    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    /**
     * A method that generated an array, which is a result of a multiplication of a 2-dimensional array
     * of double-data and a vector;
     *
     * @param matrix a 2-dimensional array of double-data;
     * @param vector a vector, which is actually a 1-dimensional array;
     * @return a 1-dimensional array, which is a result of "matrix" and "vector";
     */
    static double[] mul(double[][] matrix, double[] vector) {
        if (matrix[0].length == vector.length) {
            double[] array = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    array[i] = array[i] + matrix[i][j] * vector[j];
                }
            }
            return array;
        } else {
            return null;
        }
    }

    /**
     * A method that generated an array, which is a result of a multiplication of two 2-dimensional array;
     *
     * @param matrixLeft  the first 2-dimensional array of double-data;
     * @param matrixRight the second 2-dimensional array of double-data;
     * @return a 2-dimensional array, which is a result of a multiplication of two 2-dimensional array;
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        if (matrixLeft[0].length == matrixRight.length) {
            double[][] mas = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixLeft[0].length; k++) {
                        mas[i][j] = mas[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
            return mas;
        } else {
            return null;
        }
    }
}
