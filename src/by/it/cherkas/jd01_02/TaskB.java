package by.it.cherkas.jd01_02;
import java.util.Scanner;

    public class TaskB {
    public static void main(String[] args) {
            step1();
            Scanner sc=new Scanner(System.in);
            int month=sc.nextInt();
            step2 (month);

            double a=sc.nextDouble();
            double b=sc.nextDouble();
            double c=sc.nextDouble();
            step3 (a, b, c);
    }

         private static void step1() {
            for (int i = 0; i <=25 ; i++) {
                System.out.print(i + " ");
                if (i % 5 == 0)
                    System.out.println();

            }
        }
        static void step2(int month){

        }
        static void step3(double a, double b, double c){

        }
    }
