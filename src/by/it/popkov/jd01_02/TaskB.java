package by.it.popkov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        step2(scanner.nextInt());
        step3(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
    }

    private static void step1() {
        int[][] arrayOfArrays = new int[5][5];
        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays.length; j++) {
                arrayOfArrays[i][j] = j + 1 + i * arrayOfArrays.length;
                System.out.print(arrayOfArrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double d = b * b - 4.0 * a * c;
        if (d > 0) {
            double firstX = (-b + Math.sqrt(d)) / (a * 2.0);
            double secondX = (-b - Math.sqrt(d)) / (a * 2.0);
            System.out.println(firstX + " " + secondX);
        } else if (d == 0) {
            double x = -b / (2.0 * a);
            System.out.println(x);
        } else {
            System.out.println("корней нет");
        }
    }
}
