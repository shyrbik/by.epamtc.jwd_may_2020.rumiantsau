package by.it.potapovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] employes = new String[n];
        for (int i = 0; i < employes.length; i++) {
            employes[i] = scanner.nextLine();


        }


        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + employes[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();


            }
        }
        System.out.printf("%-25s %-11s %-11s %-11s %-11s %-25s %n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------------------------------------------------------");
        double total = 0;
        double middle = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum = sum + salary[i][j];
            }
            total = total + sum;
            System.out.printf("%-25s %-11d %-11d %-11d %-11d %-25d %n", employes[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], sum);

            //   System.out.printf("%-25s %-11d %-11d %-11d %-11d %-25d %n",employes[i],salary [i][j],salary [i][j],salary [i][j],salary [i][j],sum);
            //  System.out.printf("%-25s %-11d %-11d %-11d %-11d %-25d %n",employes[i],salary [i][j],salary [i][j],salary [i][j],salary [i][j],sum);
        }
        middle = total / (n * 4);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s %-11.4f %n","Итого", total);
        System.out.printf("%-25s %-11.4f %n", "Средняя",middle);


    }
}

