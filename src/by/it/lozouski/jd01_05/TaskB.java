package by.it.lozouski.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%3.1f Сумма y =%8.6e%n",a,y);
        }
    }
}
