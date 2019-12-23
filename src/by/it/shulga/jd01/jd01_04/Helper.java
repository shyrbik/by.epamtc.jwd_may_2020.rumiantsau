package by.it.shulga.jd01.jd01_04;

public class Helper {

    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            System.out.println("Минимум массива Min= " + min);
            return min;

        }

    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            System.out.println("Максимум массива Max= " + max);
            return max;
        }


    }

    static void sort(double[ ] arr) {

        boolean swap;
        int last=arr.length-1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        System.out.println("Сортировка массива по возрастанию: ");
        for (double v : arr)
            System.out.println(v);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        System.out.println("Результат умножения матрицы на вектор: ");
        for (double q : z)
            System.out.println(q);
       return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] w = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length ; i++) {
            for (int j = 0; j < matrixRight[0].length ; j++) {
                for (int k = 0; k < matrixRight.length ; k++) {
                    w[i][j] = w[i][j] + matrixRight[i][k] * matrixLeft[k][j];
                }
            }
        }
        System.out.println("Результат умножения матрицы на матрицу: ");
        for (int i = 0; i < w.length ; i++) {
            for (int j = 0; j < w[0].length ; j++) {
                System.out.printf("% -6.0f", w[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        return w;
    }
}