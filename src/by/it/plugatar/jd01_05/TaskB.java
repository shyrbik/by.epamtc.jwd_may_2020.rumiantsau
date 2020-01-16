package by.it.plugatar.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
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

  public static void step5() {
    double b;
    System.out.println("\n\nЗадание B2:");
    for (double x = -5.5; x < 2; x += 0.5) {
        System.out.printf("При x/2 = %5.2f", x / 2);
        if (x / 2 > -2 && x / 2 <= -1) b = Math.sin(Math.pow(x, 2));
        else if (x / 2 > -1 && x / 2 < 0.2) b = Math.cos(Math.pow(x, 2));
        else if (x / 2 == 0.2) b = 1 / Math.tan(Math.pow(x, 2));
        else {
            System.out.println(" вычисления не определены");
            continue;
        }
        double a = Math.log10(Math.abs(b + 2.74));
        System.out.printf(" a = %-8.6f\n", a);

    }
  }
}
