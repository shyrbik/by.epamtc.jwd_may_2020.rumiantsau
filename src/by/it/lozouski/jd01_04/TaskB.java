package by.it.lozouski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите количество работников:");
        int quantityPerson = sc1.nextInt();
        int quarterYear = 4;
        String[] lastName = new String[quantityPerson];
        System.out.println("Введите фамилии работников:");
        for (int i = 0; i < lastName.length; i++) lastName[i] = sc1.next();
        int[][] salary = new int[lastName.length][quarterYear];
        for (int i = 0; i < lastName.length; i++) {
            System.out.println("Введите зарплату для фамилии:" + lastName[i]);
            for (int j = 0; j < quarterYear; j++) {
                salary[i][j] = sc1.nextInt();
            }
        }

        int[] totalSalaryInQuarter = new int[quantityPerson];
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;
            for (int j = 0; j < quarterYear; j++) {
                sum += salary[i][j];
            }
            totalSalaryInQuarter[i] = sum;
        }
        int total = 0;
        for (int value : totalSalaryInQuarter) {
            total += value;
        }
        double averageSalary = (double) total / (quantityPerson * quarterYear);

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия    Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < quantityPerson; i++) {
            System.out.printf("%9s: ", lastName[i]);
            for (int j = 0; j < quarterYear; j++) {
                System.out.printf("%-9d ", salary[i][j]);
            }
            System.out.printf("%-5d"+'\n', totalSalaryInQuarter[i]);
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("Итого    " + "%-3d" + '\n' + "Средняя " + "% -9.4f" + '\n', total, averageSalary);
    }
}
