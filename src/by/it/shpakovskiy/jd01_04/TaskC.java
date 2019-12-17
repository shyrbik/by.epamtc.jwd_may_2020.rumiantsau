package by.it.shpakovskiy.jd01_04;

import java.util.Scanner;

public class TaskC {
    static void buildOneDimArray(String line) {
        String[] arrayStrings = line.trim().split(" ");
        double[] array = new double[arrayStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(arrayStrings[i]);
        }
        printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        printArray(array, "V", 4);
        System.out.printf("Index of first element=%d\n", binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", binarySearch(array, last));
    }

    //quick3Sort(double[] array)
    static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    //quick3Sort(double[] array, int left, int right)
    private static void mergeSort(double[] array, int left, int right) {
        if (right <= left) return;
        int lt = left;
        int rt = right;
        int i = left + 1;
        double pivotValue = array[left];
        while (i <= rt) {
            if (array[i]<pivotValue) {
                swap(array, i++, lt++);
            } else if (pivotValue<array[i]) {
                swap(array, i, rt--);
            } else {
                i++;
            }
        }
        mergeSort(array, left, lt - 1);
        mergeSort(array, rt + 1, right);
    }

    private static void swap(double[] array, int i, int j) {
        double buf = array[i];
        array[i] = array[j];
        array[j] = buf;
    }

    private static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f", name, i, array[i]);
            if ((i + 1) % columnCount == 0) System.out.println();
        }
        System.out.println();
    }

    static int binarySearch(double[] array, double value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == value) {
                return middleIndex;
            }
            else if (array[middleIndex] < value)
                firstIndex = middleIndex + 1;
            else if (array[middleIndex] > value)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        buildOneDimArray(scanner.nextLine());
    }
}
