package by.it.drozd.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        String[] people=new String[n];
        for (int i = 0; i < people.length; i++) {
            people[i] = scan.next();
        }


        int[][] pays=new int[n][4];
        for (int i = 0; i < pays.length; i++) {
            System.out.println("Введите зарплату для "+people[i]);
            for (int j = 0; j < pays[0].length; j++) {
                pays[i][j]=scan.nextInt();

            }
        }
        int sum=0;
        for (int i = 0; i < pays.length; i++) {
            for (int i1 = 0; i1 < pays[0].length; i1++) {
               sum+=pays[i][i1];
            }
        }
        double average=sum/12d;
        System.out.println("---------------------------------------------");
        System.out.print("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итог");
        System.out.println();
        System.out.println("---------------------------------------------");
        for (int q = 0; q < pays.length; q++) {
            System.out.printf("%2s:",people[q]);
            for (int s = 0; s < pays[0].length; s++) {
                System.out.printf("%-8d",pays[q][s]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
        System.out.println("Итого  "+sum);
        System.out.printf("%.4f",average);
    }
}


