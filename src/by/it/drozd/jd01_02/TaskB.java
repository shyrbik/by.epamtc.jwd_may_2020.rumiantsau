package by.it.drozd.jd01_02;

import java.util.Scanner;

import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int resultMonth=sc.nextInt();
        int resultNumb1=sc.nextInt();
        int resultNumb2=sc.nextInt();
        int resultNumb3=sc.nextInt();

    step1();
    step2(resultMonth);
    step3(resultNumb1,resultNumb2,resultNumb3);

    }
    private static void step1(){
        int mat=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mat++;
                System.out.print(mat +" ");
            }
            System.out.println();
        }
    }
    private static void step2(int month){
    switch (month){
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
    double discriminant= b*b - 4 * a * c;
    if(discriminant>0){
    double x1=(-b+Math.sqrt(discriminant))/(2*a);
    double x2=(-b-Math.sqrt(discriminant))/(2*a);
        System.out.println("x1= "+x1+" "+"x2= "+x2);
    }
        else if (discriminant==0){
    double x1=-b/(2*a);
        System.out.println("x1= "+x1);
        }
        else{
        System.out.println("корней нет");
    }
    }


}
