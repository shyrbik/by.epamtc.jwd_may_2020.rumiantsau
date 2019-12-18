package by.it.shulga.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step1();

    }


    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = ((pow(7, a) - cos(1)) + (pow(7, a) - cos(2)) + (pow(7, a) - cos(3)) + (pow(7, a) - cos(4))
                    + (pow(7, a) - cos(5)) + (pow(7, a) - cos(6)));

            System.out.println("При а= " + a + "Сумма Y=" + y);
        }
    }


}

//  double y = ((pow(7, a)-cos(1))+ (pow(7, a)-cos(2))+ (pow(7, a)-cos(3))+ (pow(7, a)-cos(4))
//  + (pow(7, a)-cos(5)) + (pow(7, a)-cos(6)))  ;
