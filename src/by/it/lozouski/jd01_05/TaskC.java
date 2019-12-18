package by.it.lozouski.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        stepC1();
    }

    private static void stepC1() {
        int sizeA = (int) ((9 - 5.33) / 0.131071);
        double[] arrayA = new double[sizeA];
        for (int i = 0; i < arrayA.length; i++) {
            for (double x = 5.33; x <= 9; x += 0.131071) {
                double z;
                z = cbrt(pow(x, 2) + 4.5);
                if (i >= arrayA.length) break;
                arrayA[i] = z;
                i++;
            }
        }
        int sizeB = 0;
        for (double index : arrayA) {
            if (index > 3.5) sizeB++;
        }
        double[] arrayB = new double[sizeB];
        int x = 0;
        int y = 0;
        while (x < arrayA.length) {
            if (arrayA[x] > 3.5) {
                arrayB[y] = arrayA[x];
                x++;
                y++;
            } else x++;
        }

        System.out.println("Массив А[]");
        printArray(arrayA, "A");
        System.out.println("Массив B[] из элементов массива A > 3.5");
        printArray(arrayB, "B");
        System.out.printf("Среднее геометрическое элементов массива В =% 7.5f", srGeom(arrayB));
    }

    private static void printArray(double[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d] =% 7.5f ", name, i, arr[i]);
            if ((i + 1) % 5 == 0 || i + 1 == arr.length) System.out.println();
        }
    }

    private static double srGeom(double[] arrayB) {
        double factB = 1;
        int mul = 0;
        do {
            factB *= arrayB[mul];
            mul++;
        } while (mul < arrayB.length - 1);
        return pow(factB, 1.0 / arrayB.length);
    }
}
