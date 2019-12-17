package by.it.ban.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
       // step2();
    }

    private static void step1() {
        double a=756.13;
        double x=0.3;
        double z;
        z= cos(pow((x*x+ PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println(z);
    }

//    private static void step2() {
//        double a=1.21;
//        double b=0.371;
//        double y;
//        y=
//    }
}
