package by.it.borodachev.jd01_02;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;
import java.lang.Math;
import static javafx.scene.input.KeyCode.J;

public class TaskB {
    public static void main(String[] args)
    {
        step1();
        Scanner inp=new Scanner(System.in);

        step2(inp.nextInt());

        step3(inp.nextDouble(), inp.nextDouble(), inp.nextDouble());

    }
    private static void step3(double a, double b, double c) {
        double discriminant=b*b-4*a*c;

        if ((discriminant<0) | (a==0)) {
            System.out.println("корней нет");
        }
           else{
            discriminant=Math.sqrt(discriminant);
            System.out.println((-1*b-discriminant)/2/a);
            System.out.println((-1*b+discriminant)/2/a);
        }
    }
    private static void step2(int month) {
         String m[] = {"январь",
                "февраль",
                "март",
                "апрель",
                "май",
                "июнь",
                "июль",
                "август",
                "сентябрь",
                "октябрь",
                 "ноябрь",
                "декабрь"};
         if ((month >12) || (month <=0)) {
             System.out.println("нет такого месяца");
         }
             else {
                 System.out.println(m[month-1]);
             }
         }


    private static void step1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((i*5+j+1)+" ");
            }
            System.out.println("");
        }

    }
}
