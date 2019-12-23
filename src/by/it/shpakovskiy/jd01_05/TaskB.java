package by.it.shpakovskiy.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        for (double x = -6; x < 2; x += 0.5) {
            if (x / 2 > -2 && x * 2 <= -1) {
                System.out.printf("При x/2=%6.2f a = %g\n", x / 2, log10(abs(sin(x * x) + 2.74)));
            }
            if (x/2>-1&&x/2<0.2){
                System.out.printf("При x/2=%6.2f a = %g\n", x / 2, log10(abs(cos(x * x) + 2.74)));
            }
            if (x/2==0.2){
                System.out.printf("При x/2=%6.2f a = %g\n", x / 2, log10(abs(1/tan(x * x) + 2.74)));
            }
        }
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 0; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%6.2f Сумма y=%g\n", a, y);
        }
    }
}
