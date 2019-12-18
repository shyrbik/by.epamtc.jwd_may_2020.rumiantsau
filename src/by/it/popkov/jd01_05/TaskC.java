package by.it.popkov.jd01_05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {

        step2();
    }

    private static void step2() {
        ArrayList<Integer> b = new ArrayList<>();
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) round(random() * 347 + 103);
            if (a[i] / 10.0 > i) {
                b.add(a[i]);
            }
        }
        Collections.sort(b);

        System.out.println("Array A (index of rows)");
        System.out.print("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗\n");
        for (int i = 0; i < a.length; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.print("\n╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
                System.out.print("\n╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗\n");
            }
            if ((i + 1) % 5 == 0) {
                System.out.printf("║ A[%2d]=%d ║", i + 1, a[i]);
            } else {
                System.out.printf("║ A[%2d]=%d ", i + 1, a[i]);
            }
        }
        System.out.print("\n╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");


        System.out.println("\nArray B (index of cols)");
        System.out.print("╔═══════════╦═══════════╗\n");
        for (int i = 0; i < b.size(); i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.print("\n╚═══════════╩═══════════╝");
                System.out.print("\n╔═══════════╦═══════════╗\n");
            }
            if ((i + 1) % 2 == 0) {
                System.out.printf("║ B[%2d]=%d ║", (i + b.size()) / 2 + 1, b.get((i + b.size()) / 2));
            } else {
                System.out.printf("║ B[%2d]=%d ", i / 2 + 1, b.get(i / 2));
            }
        }
        System.out.print("\n╚═══════════╩═══════════╝");
    }

    private static void step1() {
        int counter = 0;
        double[] a = new double[28];
        System.out.print("Массив A[]");

        for (double x = 5.33, i = 0; x <= 9; x += 0.135, i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            a[(int) i] = cbrt(pow(x, 2) + 4.5);
            if (a[(int) i] > 3.5) counter++;
            System.out.printf("A[ %-2d] = %-7.5f    ", (int) i, a[(int) i]);
        }

        double[] b = new double[counter];

        for (double x = 5.33, v = 0, count = 0; x <= 9; x += 0.135, v++) {
            a[(int) v] = cbrt(pow(x, 2) + 4.5);
            if (a[(int) v] > 3.5) {
                b[(int) count] = a[(int) v];
                count++;
            }
        }
        System.out.print("\n\nМассив B[] из элементов массива A > 3.5");
        for (int i = 0; i < b.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("B[ %-2d] = %-7.5f    ", i, b[i]);
        }
    }


}
