package by.it.borodachev.jd01_02;

import java.util.Scanner;

public class TaskA {


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = inp.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step3(int[] mas) {
        int minValue = mas[0];
        for (int v : mas) {
            if (v < minValue) {
                minValue = v;
            }
        }
        for (int i = mas.length - 1; i >= 0; i--)  {
            if (mas[i] == minValue) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void step2(int[] mas) {
        double avg=0;
        for (int i = 0; i < mas.length; i++) {
            avg += mas[i];
        }
        avg /= mas.length;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < avg) {
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println("");
    }


    static void step1(int[] mas) {
        int maxValue = mas[0];
        int minValue = mas[0];
        for (int v : mas) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }

        }
        System.out.println(minValue + " " + maxValue);
    }
}
