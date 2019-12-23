package by.it.lozouski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String line = sc1.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element=" + Arrays.binarySearch(array, first));
        System.out.println("Index of last element=" + Arrays.binarySearch(array, last));
    }

    public static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (array == null) return;
        if (left >= right) return;
        int l = left;
        int r = right;
        double middle = array[(left + (right - left) / 2)];
        while (l <= r) {
            while (array[l] < middle) {
                l++;
            }
            while (array[r] > middle) {
                r--;
            }
            if (l <= r) {
                double tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
                l++;
                r--;
            }
        }
        if (left < r) mergeSort(array, left, r);
        if (right > l) mergeSort(array, l, right);
    }

    private static int binarySearch(double[] array, double value) {
        int leftIndex = 0;
        int rightIndex = array.length;
        while (true) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            if (array[mid] == value)
                return mid;

            if (array[mid] > value)
                rightIndex = mid;
            else
                leftIndex = mid + 1;
        }
    }
}

