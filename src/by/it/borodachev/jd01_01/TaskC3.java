package by.it.borodachev.jd01_01;

import java.util.Scanner;

public class TaskC3 {
    static double earth=9.81;
    static double mars=3.86;

     public static void main(String[] args) {
        int a;

        Scanner inp=new Scanner(System.in);
        a=inp.nextInt();
         System.out.println(getWeight(a));


    }

    private static double getWeight(int a) {

        int a100;
        int a1000;
        a1000=(int)(a/earth*mars*1000.0);
        a100=(int)(a1000/10.0);
        if (a1000-a100*10 >=5) {
            a100 = a100 + 1;
        }
        return (double)a100/100;

    }
}
