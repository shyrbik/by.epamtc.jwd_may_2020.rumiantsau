package by.it.cherkas.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        for (double a = 0; a <=2 ; a+=0.2) {
            int s=1;
            if (s<=6) {
                double y = s * (pow(7, a));
                s++;
                for (double x = 1; x <= 6; x++) {
                    y = y - cos(x);
                    System.out.printf("при a=%6.2f f=%g\n", a, y);

                }

            }
        }


    }
}
