package by.it.popkov.jd01_04;


class Helper {

    /**
     * @param result - takes double[]
     * @return return minimum element of double[] result
     */
    static double findMin(double[] result) {
        double min = Double.MAX_VALUE;
        for (double v : result) {
            if (v < min) min = v;
        }
        return min;
    }

    /**
     * @param result - takes double[]
     * @return return maximum element of double[] result
     */
    static double findMax(double[] result) {
        double max = Double.MIN_VALUE;
        for (double v : result) {
            if (v > max) max = v;
        }
        return max;
    }

    static void sort(double[] result) {
        for (int i = result.length - 1; i >= 0; i--) {
            boolean check = true;
            for (int j = 0; j < i; j++) {
                if (result[j] > result[j + 1]) {
                    double stash = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = stash;
                    check = false;
                }
            }
            if (check) break;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] outPut = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                outPut[i] = outPut[i] + matrix[i][j] * vector[j];
            }
        }
        return outPut;
    }

    static double[][] mul(double[][] matrixFirst, double[][] matrixSecond) {
        double[][] outPut = new double[matrixFirst.length][matrixSecond[0].length];
        for (int i = 0; i < matrixFirst.length; i++) {
            for (int j = 0; j < matrixSecond[0].length; j++) {
                for (int y = 0; y < matrixSecond.length; y++) {
                    outPut[i][j] = outPut[i][j] + matrixFirst[i][y] * matrixSecond[y][j];
                }
            }
        }
        return outPut;
    }


}
