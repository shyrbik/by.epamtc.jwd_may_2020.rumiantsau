package by.it.tarasevich.jd01_05;

import javax.xml.stream.FactoryConfigurationError;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }


    private static void step1() {
        double sum = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                sum = sum + (-cos(x));
                if (x % 6 == 0) {
                    double y = 6 * pow(7, a) + sum;
                    System.out.printf("При a=%4.2f Сумма  y = %e\n", a, y);
                }
            }
        }
    }

    private static void step2() {
        double b;
        for (double x = -6; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %e\n", x / 2, a);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %e\n", x / 2, a);
            } else if (x / 2 == 0.2) {
                b = 1/tan(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %e\n", x / 2, a);
            }
            else {
                System.out.printf("При x/2=%5.2f вычисления не произведены\n", x/2);
            }
        }
    }
}
