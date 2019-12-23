package by.it.shpakovskiy.jd01_02;

import java.util.Scanner;

public class TaskA {
    static void step1(int[] mass) {
        int min = mass[0];
        int max = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
            }
            if (max < mass[i]) {
                max = mass[i];
            }
        }

        System.out.println(min + " " + max);
    }

    static void step2(int[] mass) {
        double d;
        int sum = mass[0];
        for (int i = 1; i < mass.length; i++) {
            sum += mass[i];
        }
        d = (double) sum / mass.length;
        for (int a :
                mass) {
            if ((double) a < d) {
                System.out.print(a + " ");
            }
        }
    }

    static void step3(int[] mass) {
        int min = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
            }
        }
        for (int i = mass.length - 1; i >= 0; i--) {
            if (min == mass[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mass = new int[10];
        for (int i = 0; i < 10; i++) {
            mass[i] = scanner.nextInt();
        }
        step1(mass);
        step2(mass);
        step3(mass);
    }
}
