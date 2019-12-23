package by.it.drozd.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        buildOneDimArray(str);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int result = i * j;
                System.out.printf("%d%s%d=%-2d ", i, "*", j, result);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
            for (int j = 0; j < array.length; j++) {
                if (array[i] == last) {
                    System.out.println("Index of last element=" + i);
                    break;
                }
            }

        }
    }
}
