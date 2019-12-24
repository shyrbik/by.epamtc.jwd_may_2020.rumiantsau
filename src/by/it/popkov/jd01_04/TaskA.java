package by.it.popkov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        buildOneDimArray(scanner.nextLine());
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        System.out.printf("Index of first element=%d\n", Arrays.binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", Arrays.binarySearch(array, last));


    }

    static void printMulTable() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }
}
