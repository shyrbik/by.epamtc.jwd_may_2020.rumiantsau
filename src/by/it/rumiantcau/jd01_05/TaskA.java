package by.it.rumiantcau.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();





    }




    private static void taskA1() {
        System.out.println("Zadanie A1");
        double z,z1,z2,z3;
        double a=756.13;
        double x=0.3;

        z1 = pow(cos(x*x+Math.PI/6),5);
        z2 = sqrt(x*pow(a,3));
        z3 = log(abs((a-1.12*x)/4));
        z = z1-z2-z3;
        System.out.println("z = "+z);
        System.out.println();
        z = pow(cos(x*x+Math.PI/6),5)-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println("alt z ="+z);
        System.out.println();
    }

    private static void taskA2() {
        System.out.println("Zadanie A2");
        double y, a=1.21, b=0.371;
        y = pow(tan(a+b),2)-cbrt(a+1.5)+a*pow(b,5)-b/log(a*a);
        System.out.println("y ="+y);
        System.out.println();
    }

    private static void taskA3() {
        System.out.println("Zadanie A3");
        double f,x=12.1,a=-5;
        while (a<=12){
            f = pow(E, a*x) - 3.75*a;
            System.out.println("f = "+f+" pri a ="+a);
            a = a+3.75;
        }
        System.out.println();

    }



}
