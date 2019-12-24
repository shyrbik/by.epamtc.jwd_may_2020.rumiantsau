package by.it.tarasevich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }


    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double res1 = cos(pow((x * x + Math.PI / 6), 5));
        double res2 = sqrt(x * pow(a, 3));
        double res3 = log(abs((a - 1.12 * x) / 4));
        double z = res1 - res2 - res3;
        System.out.println("z=" + z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double res1 = tan(pow((a + b), 2));
        double res2 = cbrt(a + 1.5);
        double res3 = a * pow(b, 5);
        double res4 = b / (log(pow(a, 2)));
        double y = res1 - res2 + res3 - res4;
        System.out.println("y=" + y);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = pow(E, a * x) - 3.45 * a;
            System.out.printf("При a=%6.2f f=%g\n", a, f);

        }

    }

}