package by.it.cherkas.jd01_04;


import javax.swing.*;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число людей");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(k);
        String[] surname = new String[3];
        System.out.println("Введите фамилии");
        String surname1 = sc.next();
        String surname2 = sc.next();
        String surname3 = sc.next();
        {
            System.out.println(surname1 + "\n" + surname2 + "\n" + surname3);
        }
        {

            int n = 0;
            int[][] salary = new int[n][4];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("Введите зарплату" + surname[i]);
                    salary[i][j] = sc.nextInt();
                    System.out.println("Введите зарплату для Иванова");
                    String salary1 = sc.next();
                    System.out.println("Введите зарплату для Петрова");
                    String salary2 = sc.next();
                    System.out.println("Введите зарплату для Сидорова");
                    String salary3 = sc.next();
                    System.out.println(salary1 + "\n" + salary2 + "\n" + salary3);

                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.printf("%-25s %-11s %-11s %-11s %-11s %-25s %n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            double total = 0;
            double middle = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum = sum + salary[i][j];
                }
                total = total + sum;
                System.out.printf("%-25s %-11s %-11s %-11s %-11s %-25s %n", surname[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], sum);
            }
        }
    }
}