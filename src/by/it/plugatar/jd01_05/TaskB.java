package by.it.plugatar.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step4();
    }

    private static void step4() {
        double y = 0;
        double a;
        for (a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
                System.out.printf("При а=%6.2f y=%g\n", a, y);
            }

        }

    }
}
