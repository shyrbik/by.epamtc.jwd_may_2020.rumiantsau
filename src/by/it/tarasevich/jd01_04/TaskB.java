package by.it.tarasevich.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // число людей
        String[] surname = new String[n]; // заполняем массив фио
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scanner.nextLine();
        }
        Integer[][] salary = new Integer[n][4]; // массив
        for (int i = 0; i < salary.length; i++) {  //строки
            for (int j = 0; j < salary[i].length; j++) { // столбцы
                salary[i][j] = scanner.nextInt();
                System.out.printf("%s: %-3d", surname[i], salary[i][j]);
            }
            System.out.println();
        }
    }
}
