package by.it.lozouski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;


public class TaskA {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String line = sc1.nextLine();
        printMulTable();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        Helper.sort(array,0,array.length-1);
        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element=" + Arrays.binarySearch(array, first));
        System.out.println("Index of last element=" + Arrays.binarySearch(array, last));
    }
}
