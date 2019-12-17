package by.it.ban.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        step1();
        int month;
        month = sc.nextInt();
        step2(month);
        double a, b, c;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        step3(a, b, c);
    }

    private static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    private static void step2(int month) {
        String mnthStr;
        switch (month) {
            case 1:
                mnthStr = "январь";
                break;
            case 2:
                mnthStr = "февраль";
                break;
            case 3:
                mnthStr = "март";
                break;
            case 4:
                mnthStr = "апрель";
                break;
            case 5:
                mnthStr = "май";
                break;
            case 6:
                mnthStr = "июнь";
                break;
            case 7:
                mnthStr = "июль";
                break;
            case 8:
                mnthStr = "август";
                break;
            case 9:
                mnthStr = "сентябрь";
                break;
            case 10:
                mnthStr = "октябрь";
                break;
            case 11:
                mnthStr = "ноябрь";
                break;
            case 12:
                mnthStr = "декабрь";
                break;
            default:
                mnthStr = "нет такого месяца";
        }
        System.out.println(mnthStr);
    }

    private static void step3(double a, double b, double c) {
        double d;
        double x1, x2;
        d = b * b - 4 * a * c;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (d == 0) {
            x1 = -b / (2 * a);
            System.out.println(x1);
        } else
            System.out.println("корней нет");
    }
}
