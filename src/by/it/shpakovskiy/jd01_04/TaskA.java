package by.it.shpakovskiy.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void sort(double[] arr) {
        int k = arr.length / 2;
        while (k > 0) {
            for (int i = 0; i < arr.length - k; i++) {
                int j = i;
                while (j >= 0 && arr[j] > arr[j + k]) {
                    double buf = arr[j];
                    arr[j] = arr[j + k];
                    arr[j + k] = buf;
                    j--;
                }
            }
            k = k / 2;
        }
    }

    private static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f", name, i, array[i]);
            if ((i + 1) % columnCount == 0) System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        String[] arrayStrings = line.trim().split(" ");
        double[] array = new double[arrayStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(arrayStrings[i]);
        }
        printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        sort(array);
        printArray(array, "V", 4);
        System.out.printf("Index of first element=%d\n", Arrays.binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", Arrays.binarySearch(array, last));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        buildOneDimArray(scanner.nextLine());
    }
}
