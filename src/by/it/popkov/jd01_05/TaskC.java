package by.it.popkov.jd01_05;


import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        step1();
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
