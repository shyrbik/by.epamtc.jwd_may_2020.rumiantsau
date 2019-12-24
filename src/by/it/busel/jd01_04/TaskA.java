package by.it.busel.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
//        buildOneDimArray("10 9 8 7 6 5 4 3 2 1 0 -1 -2 -3 -4 -5 -6 -7 -8 -9 -10");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }

    static void buildOneDimArray(String line) {
        double[] arrayOfDoubles = InOut.getArray(line);
        InOut.printArray(arrayOfDoubles, "V", 5);
        double firstElement = arrayOfDoubles[0];
        double lastElement = arrayOfDoubles[arrayOfDoubles.length - 1];
        Helper.sort(arrayOfDoubles);
        InOut.printArray(arrayOfDoubles, "V", 4);
        System.out.printf("Index of first element=%d%n", Helper.binarySearch(arrayOfDoubles, firstElement));
        System.out.printf("Index of last element=%d%n", Helper.binarySearch(arrayOfDoubles, lastElement));


    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.printf("%n");
        }
    }
}
