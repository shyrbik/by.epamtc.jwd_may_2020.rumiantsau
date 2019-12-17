package by.it.busel.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas = step1(n);
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
        Random rd = new Random();
        int[][] mas = new int[n][n];
        boolean nMinus = false;
        boolean nPlus = false;
        outer:
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = rd.nextInt(n - (-n) + 1) + (-n);
                    if (mas[i][j] == n) {
                        nPlus = true;
                    } else if (mas[i][j] == -n) {
                        nMinus = true;
                    }
                    if (nPlus && nMinus) {
                        break outer;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }

    static int step2(int[][] mas) {
//        int[][] masCopy = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                masCopy[i][j] = mas[i][j];
//            }
//        }
        // Sum is a return-value;
        int sum = 0;
        // sumOfPositiveInALine[i] is a sum of numbers between two first positive numbers in a line "i";
        int[] sumOfPositiveInALine = new int[mas.length];
        // positiveFirst[i] contains an information if a line "i" possesses the 1st positive number;
        boolean[] positiveFirst = new boolean[mas.length];
        // positiveSecond[i] contains an information  if a line "i" possesses the 2nd positive number;
        boolean[] positiveSecond = new boolean[mas.length];
        // indexPositiveFirst[i] shows the definite index of the 1st positive number in a line "i";
        int[] indexPositiveFirst = new int[mas.length];
        // indexPositiveSecond[i] shows the definite index of the 2nd positive number in a line "i";
        int[] indexPositiveSecond = new int[mas.length];
        // A loop which finds out if a line "i" possesses the 1st positive number and the 2nd positive number.
        for (int i = 0; i < mas.length; i++) {
            bothPositiveInALine:
            for (int j = 0; j < mas.length; j++) {
                if (!positiveFirst[i]) {
                    if (mas[i][j] > 0) {
                        positiveFirst[i] = true;
                        indexPositiveFirst[i] = j;
                    }
                } else if (positiveFirst[i]) {
                    if (mas[i][j] > 0) {
                        positiveSecond[i] = true;
                        indexPositiveSecond[i] = j;
                        break bothPositiveInALine;
                    }
                }
            }
        }
        // A loop which find out the sum of numbers between the 1st and the 2nd positive elements;
        for (int i = 0; i < mas.length; i++) {
            if (positiveFirst[i] && positiveSecond[i]) {
                if (indexPositiveSecond[i] - indexPositiveFirst[i] > 1) {
                    for (int j = indexPositiveFirst[i] + 1; j < indexPositiveSecond[i]; j++) {
                        sumOfPositiveInALine[i] = sumOfPositiveInALine[i] + mas[i][j];
                    }
                } else {
                    sumOfPositiveInALine[i] = 0;
                }
            } else {
                sumOfPositiveInALine[i] = 0;
            }
        }
        // A loop which gets a return-sum-value;
        for (int i = 0; i < sumOfPositiveInALine.length; i++) {
            sum = sum + sumOfPositiveInALine[i];
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        // A variable that possesses a changing maximum number of an inputted array;
        int maxValue = 0;
        // An array, which possesses information about whether a line "y" has "maxValue" in it;
        boolean[] xHasMaxValue = new boolean[mas.length];
        // An array, which possesses information about whether a column "x" has "maxValue" in it;
        boolean[] yHasMaxValue = new boolean[mas.length];
        // A loop that finds out a maximum number;
        for (int y = 0; y < mas.length; y++) {
            for (int x = 0; x < mas.length; x++) {
                if (mas[y][x] > 0) {
                    maxValue = mas[y][x];
                }
            }
        }
        // A loop that marks both lines and columns, which are to be deleted from an initial array;
        for (int y = 0; y < mas.length; y++) {
            for (int x = 0; x < mas.length; x++) {
                if (mas[y][x] == maxValue) {
                    yHasMaxValue[y] = true;
                    xHasMaxValue[x] = true;
                }
            }
        }
        int[] yCounter = new int[mas.length];
        for (int y = 0; y < yCounter.length; y++) {
            yCounter[y] = 1;
        }
        int[] xCounter = new int[mas.length];
        for (int x = 0; x < xCounter.length; x++) {
            xCounter[x] = 1;
        }
        for (int y = 0; y < mas.length; y++) {
            if (yHasMaxValue[y]) {
                yCounter[y] = 0;
                for (int x = 0; x < mas.length; x++) {
                    if (xHasMaxValue[x] && xCounter[x] == 1) {
                        xCounter[x] = 0;
                    }
                }
            } else {
                for (int x = 0; x < mas.length; x++) {
                    if (xHasMaxValue[x] && xCounter[x] == 1) {
                        xCounter[x] = 0;
                    }
                }
            }
        }
        int yModified = 0;
        for (int y = 0; y < yCounter.length; y++) {
            yModified = yModified + yCounter[y];
        }
        int xModified = 0;
        for (int x = 0; x < xCounter.length; x++) {
            xModified = xModified + xCounter[x];
        }
        int[][] masModified = new int[yModified][xModified];
        int deltaY = 0;
        // A loop that composes a new array without lines and columns, which has a maximum number;
        for (int y = 0; y < mas.length; y++) {
            if (yHasMaxValue[y]) {
                deltaY++;
                continue;
            } else {
                int deltaX = 0;
                for (int x = 0; x < mas.length; x++) {
                    if (xHasMaxValue[x]) {
                        deltaX++;
                        continue;
                    } else {
                        masModified[y-deltaY][x-deltaX] = mas[y][x];
                    }
                }
            }
        }

        for (int y = 0; y < yModified; y++) {
            for (int x = 0; x < xModified; x++) {
                System.out.println(masModified[y][x] + " ");
            }
            System.out.println();
        }
        /*for (int y = 0; y < mas.length; y++) {
            if (yHasMaxValue[y]){
                continue;
            } else {
                for (int x = 0; x < mas.length; x++) {
                    if (xHasMaxValue[x]){
                        continue;
                    }
                }
            }
        }*/
        return masModified;
    }
}
