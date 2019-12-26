package by.it.busel.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arrayOfLastNames = new String[n];
        for (int i = 0; i < arrayOfLastNames.length; i++) {
            arrayOfLastNames[i] = scanner.next();
        }
        int[][] wages = new int[n][4];
        int sumOfWages = 0;
        double[] sumWithinAQuarter = new double[4];
        for (int i = 0; i < wages.length; i++) {
            System.out.printf("Введите зарплату для %s%n", arrayOfLastNames[i]);
            for (int j = 0; j < wages[0].length; j++) {
                wages[i][j] = scanner.nextInt();
                sumOfWages = sumOfWages + wages[i][j];
                sumWithinAQuarter[j] = sumWithinAQuarter[j] + wages[i][j];
            }
        }
        double sumWithinAYear = 0;
        for (int i = 0; i < sumWithinAQuarter.length; i++) {
            sumWithinAQuarter[i] = sumWithinAQuarter[i] / n;
            sumWithinAYear = sumWithinAYear + sumWithinAQuarter[i];
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4",
                "Итого");
        for (int i = 0; i < n; i++) {
            System.out.printf("%10s%-10d%-10d%-10d%-10d%-10d%n", arrayOfLastNames[i] + ":", wages[i][0], wages[i][1],
                    wages[i][2], wages[i][3], wages[i][0] + wages[i][1] + wages[i][2] + wages[i][3]);
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-10d%n%-10s %-10.4f", "Итого", sumOfWages, "Средняя", sumWithinAYear / 4);
    }
}
