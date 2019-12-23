package by.it.tarasevich.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);

    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double first = arr[0];
        double last = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

}
