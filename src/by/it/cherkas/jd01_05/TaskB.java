package by.it.cherkas.jd01_05;


import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {


        for (double a = 0; a <= 2; a += 0.2) {
            int s = 1;
            if (s <= 6) {
                double y = s * (pow(7, a));
                s++;
                for (double x = 1; x <= 6; x++) {
                    y = y - cos(x);
                    System.out.printf("при a=%6.2f f=%g\n", a, y);

                }


                {
                    double α = 0;
                    double β = 0;
                    for (double x = -6; x < 2; x += 0.5) {
                        x = (x / 2) * 2;
                        if (x / 2 > -2 && x / 2 <= -1) {
                            β = sin(pow(x, 2));
                        }
                        System.out.printf("при x=%6.2f β=%g\n", x, β);
                        if (-1 < x / 2 && x / 2 < 0.2) {
                            β = cos(pow(x, 2));
                        }
                        System.out.printf("при x=%6.2f β=%g\n", x, β);
                        if (x / 2 == 0.2) {
                            β = 1 / (tan(pow(x, 2)));
                        }
                        System.out.printf("при x=%6.2f β=%g\n", x, β);
                    }
                    α = log(β + 2.74);
                    System.out.println(Math.abs(α));

                }


            }
        }
    }
}



