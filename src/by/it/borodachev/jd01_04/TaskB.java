package by.it.borodachev.jd01_04;

import java.util.Scanner;

    public class TaskB {
        public static void main(String[] args) {
            Scanner inp = new Scanner(System.in);
            int peopleCount = inp.nextInt();
            String[] fio = new String[peopleCount];
            fio[0] = inp.nextLine();
            for (int i = 0; i < fio.length; i++) {
                fio[i] = inp.nextLine();
            }
            double[][] zp = new double[peopleCount][5];
            double sumTotal = 0;
            for (int i = 0; i < fio.length; i++) {
                System.out.println("Введите зарплату для " + fio[i]);
                zp[i][4] = 0;
                for (int j = 0; j < 4; j++) {
                    zp[i][j] = inp.nextDouble();
                    zp[i][4] += zp[i][j];
                    sumTotal += zp[i][j];
                }
            }
            System.out.printf("%-11s%-11s%-11s%-11s%-11s%-11s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
            for (int i = 0; i < fio.length; i++) {
                System.out.printf("%-11s%-11.4f%-11.4f%-11.4f%-11.4f%-11.4f%n", fio[i] + ":", zp[i][0], zp[i][1], zp[i][2], zp[i][3], zp[i][4]);
             }
            System.out.printf("%-11s%-11.4f%n", "Итого", sumTotal);
            System.out.printf("%-11s%-11.4f%n", "Средняя", (sumTotal / fio.length / 4));
        }
    }



