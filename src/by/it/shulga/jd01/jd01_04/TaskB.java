package by.it.shulga.jd01.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество людей");
        int c = scan.nextInt();
        System.out.println("Введите Фамилии");
        String[] famil  = new String[c];
        for (int i = 0; i < c ; i++) {
            famil[i] = scan.next();
        }
             int[][] zrp = new int[c][4];
        for (int i = 0; i < c ; i++) {
                System.out.println("Введите зарплату для " + famil[i]);
                zrp [i][0]  = scan.nextInt();
                zrp [i][1]  = scan.nextInt();
                zrp [i][2]  = scan.nextInt();
                zrp [i][3]  = scan.nextInt();
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Фамилия    Квартал 1    Квартал 2    Квартал 3    Квартал 4    Итого");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < c ; i++) {
            System.out.printf("%-6s:       %-7d      %-7d      %-7d      %-7d     %-7d",
                    famil[i], zrp[i][0], zrp[i][1], zrp[i][2], zrp[i][3], zrp[i][0] + zrp[i][1] + zrp[i][2] + zrp[i][3]);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------");
        int summa = 0, viplat = 0;

        for (int i = 0; i <c ; i++) {
             summa +=  zrp[i][0] + zrp[i][1] + zrp[i][2] + zrp[i][3];
             viplat+= i*4;
        }
        System.out.println("Итого "+summa);
        double summades =summa;
        double srednee =summades/viplat;
        System.out.printf("Средняя %10.4f", srednee);
    }
}
