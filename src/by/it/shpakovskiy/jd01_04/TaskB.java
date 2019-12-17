package by.it.shpakovskiy.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastNames = new String[n];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < lastNames.length; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Фамилия   \t" + "Квартал1\t" + "Квартал2\t" + "Квартал3\t" + "Квартал4\t" + "Итого");
        System.out.println("-------------------------------------------------------------------");
        int resultSalary = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s\t", lastNames[i] + ":");
            int userResultSalary = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-8d\t", salary[i][j]);
                userResultSalary += salary[i][j];
            }
            System.out.printf("%-5d", userResultSalary);
            System.out.println();
            resultSalary += userResultSalary;
        }
        double averageSalary = (double) resultSalary / (4 * n);
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("Итого\t%d\n", resultSalary);
        System.out.printf("Сзедняя  %f", averageSalary);
    }
}
