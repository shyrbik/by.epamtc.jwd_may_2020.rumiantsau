package by.it.filipovich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        functionOne();
        functionTwo();
        functionThree();
    }

    private static void functionThree() {
        double x = 12.1;
        double delta = 3.75;
        for (double a = -5; a <=12 ; a=a+delta) {
            double f = pow(E, a*x) - 3.45*a;
            System.out.println("a = "+a+", f = "+f);
        }
    }

    private static void functionTwo() {
        double a = 1.21;
        double b = 0.371;
        double y = tan((a+b)*(a+b)) - cbrt(a+1.5) + a*pow(b, 5) - b/(log(a*a));
        System.out.println(y);
    }

    private static void functionOne() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((x*x+ PI/6),5)) - sqrt(x*pow(a,3)) - log(abs((a - 1.12*x)/4));
        System.out.println(z);
    }


}
