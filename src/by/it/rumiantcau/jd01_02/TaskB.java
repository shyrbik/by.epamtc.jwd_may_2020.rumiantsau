package by.it.rumiantcau.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
       int month = scanner.nextInt();

       double a = scanner.nextInt();
       double b = scanner.nextInt();
       double c = scanner.nextInt();
    step1();
    step2(month);
    step3(a, b, c);

    }
    static void step1() {
    int[] mas = new int[25];
    int n=5;
        for (int i = 0; i < mas.length; i++) {
          if (i==n) {
              System.out.println();
              n=n+5;
          };
            mas [i] = i + 1;
            System.out.print(mas[i]+" ");
        }
        System.out.println();
    
    }

    static void step2(int month) {

        switch (month)
        { case (1):
            System.out.println("январь");
            break;
         case (2):
             System.out.println("февраль");
             break;
            case (3):
                System.out.println("март");
                break;
            case (4):
                System.out.println("апрель");
                break;
            case (5):
                System.out.println("май");
                break;
            case (6):
                System.out.println("июнь");
                break;
            case (7):
                System.out.println("июль");
                break;
            case (8):
                System.out.println("август");
                break;
            case (9):
                System.out.println("сентябрь");
                break;
            case (10):
                System.out.println("октябрь");
                break;
            case (11):
                System.out.println("ноябрь");
                break;
            case (12):
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }

        System.out.println();
    }
    static void step3(double a, double b, double c) {
double d = b*b-4*a*c;
double x1;
double x2;
if (d>0) {
    x1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
    x2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
    System.out.println("x1="+x1+"; x2="+x2);
}
else if (d==0){x1=-b/(2*a); System.out.println("x1=x2="+x1);
}
else System.out.println("корней нет");
        System.out.println();
    }

}
