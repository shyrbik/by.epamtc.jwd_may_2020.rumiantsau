package by.it.potapovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;
//        for (int i = 0; i < month.length; i++) {
           month = scanner.nextInt();
           //int monthNames = month[i];
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();


//       }
        step1();
        step2(month);
        step3(a, b, c);



    }

    static void step1() {
        int[][] mas = new int[5][5];
        int j = 1;
        for (int n = 0; n < 5; n++) {
            for (int k = 0; k < 5; k++) {
                mas[n][k] = j;
                j++;

            }

        }
        //  {1, 2, 3, 4, 5},
        //   {6, 7, 8, 9, 10},
        //   {11, 12, 13, 14, 15},
        //  {16, 17, 18, 19, 20},
        //    {21, 22, 23, 24, 25}
        
     /*     int[][] mas = new int[5][5];
          mas[0][0]=1;
          mas[0][1]=2;
          mas[0][2]=3;
          mas[0][3]=4;
          mas[0][4]=5;
          mas[1][0]=6;
          mas[1][1]=7;
          mas[1][2]=8;
          mas[1][3]=9;
          mas[1][4]=10;
          mas[2][0]=11;
          mas[2][1]=12;
          mas[2][2]=13;
          mas[2][3]=14;
          mas[2][4]=15;
          mas[3][0]=16;
          mas[3][1]=17;
          mas[3][2]=18;
          mas[3][3]=19;
          mas[3][4]=20;
          mas[4][0]=21;
          mas[4][1]=22;
          mas[4][2]=23;
          mas[4][3]=24;
          mas[4][4]=25;
      */
        for (int n = 0; n < 5; n++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(mas[n][k] + " ");
            }
        }


    }


    private static void step2(int month) {

        /* String result = String.valueOf(month[12]);
        String[] monthNames = {
                "январь",
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
                "декабрь"
        };
      */
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }
    private static void step3(double a, double b, double c){
        double d = (b*b) - 4*a*c;
        double root;
        if (d>0){
           root = (-b +- Math.sqrt(d)) / 2*a;
            System.out.println(root + " ");
        }
        else if (d==0){
            root = - b/(2*a);
            System.out.println(root + " ");
        }
        else if (d<0){
            System.out.println("корней нет");
        }




    }
}
