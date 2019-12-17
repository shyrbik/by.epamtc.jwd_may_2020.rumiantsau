package by.it.kuzmichalex.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        step1();
    }

    /**
     * Контрольное задание номер 1. Это как хелло, ворлд, только с кандибобером!
     */
    private static void step1() {
        final double x = 0.3;
        final double a = 756.13;
        double z;
        z = cos(pow(x * x + PI / 6, 5)) -
                sqrt(x * pow(a, 3)) -
                log(abs((a - 1.12 * x) / 4));
        System.out.println("z=" + z);
    }

}
