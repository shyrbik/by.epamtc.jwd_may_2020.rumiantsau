package by.it.kuzmichalex.jd01_05;

import sun.security.x509.OtherName;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    /**
     * Тестовое задание 5. циклическое вычисление с разветвлениями
     */
    private static void step2() {
        double a;
        for (double x = -5.5; x < 2; x += 0.5) {
            double beta = 0;
            boolean betaDefined = false;
            if ((x > -4.0) && (x <= -2.0)) {
                betaDefined = true;
                beta = sin(pow(x, 2));
            }
            if ((x > -2.0) && (x < 0.4)) {
                betaDefined = true;
                beta = cos(pow(x, 2));
            }
            if (x == 0.4) {
                betaDefined = true;
                beta = cos(pow(x, 2) / sin(pow(x, 2)));
            }
            //неоптимальненько. Зато правильненько! Нечего тратить силы на оптимизацию кода, который выполнится 1 (один) раз.
            if (betaDefined) {
                a = log10(abs(beta + 2.74));
                System.out.println("при x/2=" + x /2.0 + " a=" + a);
            } else {
                System.out.println("при x/2=" + x / 2.0 + " вычисления не определены");

            }


        }

    }

    /**
     * тестовое задание 4. Вычилсение со вложенными циклами
     */
    private static void step1() {
        double x;
        double a;
        double y;
        for (a = 0.0; a <= 2.0; a += 0.2) {
            y = 0;
            for (x = 1.0; x <= 6; x++) {
                y += (pow(7, a) - cos(x));
            }
            System.out.println("При а=" + a + "сумма y=" + y);
        }
    }
}
