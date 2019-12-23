package by.it.shpakovskiy.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        System.out.println();
        step2();
    }

    private static void step1() {
        int n = (int) (random() * (40 - 20 + 1)) + 20;
        double[] z = new double[n];
        int sizeB = 0;
        double x = 5.33;
        for (int i = 0; i < z.length; i++) {
            z[i] = cbrt(x * x + 4.5);
            if (z[i] > 3.5) sizeB++;
            System.out.printf("%s[% -3d]= %g", "A", i, z[i]);
            if ((i + 1) % 5 == 0) System.out.println();
            x += (9.0 - 5.33) / n;
        }
        System.out.println();
        double[] b = new double[sizeB];
        for (int i = 0; i < b.length; i++) {
            b[i] = z[z.length - 1 - sizeB + i];
            System.out.printf("%s[% -3d]= %g ", "B", i, b[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
        System.out.println();
    }

    private static void step2() {
        int[] a = new int[31];
        int n = 0;
        System.out.println("Массив А[индекс по строке]");
        System.out.println("___________________________________________________________________________");
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (round(random() * (450 - 103 + 1) + 103));
            if (a[i] / 10 > i) n++;
            System.out.printf("| %s[% -3d]= %d |", "A", i, a[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
                System.out.println("|_____________||_____________||_____________||_____________||_____________|");
            }
            if (i == a.length - 1) {
                int f = 0;
                while (f < 4) {
                    System.out.print("|             |");
                    f++;
                }
                System.out.println();
                System.out.println("|_____________||_____________||_____________||_____________||_____________|");
            }
        }
        System.out.println();
        int[] b = new int[n];
        System.out.println("Массив B[индекс по столбцу]");
        System.arraycopy(a, a.length - 1 - n, b, 0, b.length);
        for (int i = 0; i < n / 6; i++) {
            System.out.print("_______________");
        }
        if (n % 6 > 0) {
            System.out.print("_______________");
        }
        System.out.println();
        int m = 1;
        for (int i = 0; i < 6; i++) {
            int c = 6;
            System.out.printf("| %s[% -3d]= %d |", "B", i, b[i]);
            int count=1;
            while (i + c < b.length) {
                System.out.printf("| %s[% -3d]= %d |", "B", i + c, b[i + c]);
                c += 6;
                if (i==0){
                    m++;
                }
                count++;
            }
            if (count<m){
                System.out.print("|             |");
            }
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print("|_____________|");
            }
            System.out.println();
        }
    }
}
