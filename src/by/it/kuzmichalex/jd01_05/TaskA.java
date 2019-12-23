package by.it.kuzmichalex.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        helloWorldOfMath1();
        helloWorldOfMath2();
        helloWorldOfMath3();
    }

    /**
     * Окончательный и бесповоротный Helo World. С табулированием функции!
     */
    private static void helloWorldOfMath3() {
        final double x = 12.1;
        double a;
        double y;

        for (a = -5.0; a <= 12.0; a += 3.75) {
            y = pow(E, a * x) - 3.45*a;
            System.out.println(" При a=" + a + "y=" + y);

        }

    }

    /**
     * Контрольное задание 2. Ещё одни математический Hello World
     */
    private static void helloWorldOfMath2() {
        final double a = 1.21;
        final double b = 0.371;
        double y;
        y = tan(pow(a + b, 2)) -
                cbrt(a + 1.5) +
                a * pow(b, 5) -
                b / log(pow(a, 2));
        System.out.println("y=" + y);
    }

    /**
     * Контрольное задание номер 1. Это как хелло, ворлд, только с кандибобером!
     */
    private static void helloWorldOfMath1() {
        final double x = 0.3;
        final double a = 756.13;
        double z;
        z = cos(pow(x * x + PI / 6, 5)) -
                sqrt(x * pow(a, 3)) -
                log(abs((a - 1.12 * x) / 4));
        System.out.println("z=" + z);
    }
}
