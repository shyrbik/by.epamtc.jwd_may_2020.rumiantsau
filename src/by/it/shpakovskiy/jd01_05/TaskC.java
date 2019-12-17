package by.it.shpakovskiy.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
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
        double[] b = new double[sizeB];
        for (int i = 0; i < b.length; i++) {
            b[i] = z[z.length - 1 - sizeB + i];
            System.out.printf("%s[% -3d]= %g", "B", i, b[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    private static void step2() {

    }
}
