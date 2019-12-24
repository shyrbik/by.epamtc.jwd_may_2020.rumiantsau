package by.it.popkov.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sumPay = 0;
        String[] surnames = new String[n];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = scanner.next();
        }
        int[][] pays = new int[surnames.length][4];
        for (int i = 0; i < pays.length; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < pays[0].length; j++) {
                pays[i][j] = scanner.nextInt();
                sumPay += pays[i][j];
            }
        }
        double averagePay = (double) sumPay / (4 * surnames.length);
        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < surnames.length; i++) {
            int quarterSum = pays[i][0] + pays[i][1] + pays[i][2] + pays[i][3];
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-5d\n", surnames[i], pays[i][0], pays[i][1], pays[i][2], pays[i][3], quarterSum);

        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%-10d", "Итого", sumPay);
        System.out.println();
        System.out.printf("%-9s%-10f", "Средняя", averagePay);
    }

}
