package by.it.Plugatar.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//число людей
        /*
        String [] parts=line.trim().split( " ");
        double[] result=new double[parts.length];
        */

        String[] fio = new String[n];//Фамилии
        for (int i = 0; i < n; i++) {
            //String line =sc.next();//число людей
            fio[i] = sc.next();//line.trim().split( " ");
        }
//Для ввода
        int[][] salary = new int[n][5];//Фамилии
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + fio[i]);
            for (int j = 0; j < 3; j++) {
                salary[i][j] = sc.nextInt();//line.trim().split( " ");

            }
            salary[i][4] = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            //String line =sc.next();//число людей
        }
//для вывода
        int sum=0;
        for (int i = 0; i < n; i++) {
            System.out.print(fio[i] + " :");
            for (int j = 0; j < 4; j++) {
                System.out.print(salary[i][j] + "        ");
                sum = sum + salary[i][j];
            }
            System.out.print("\n");
            //String line =sc.next();//число людей
        }
        System.out.println("Итого         " + sum);
        System.out.println("Средняя       " + sum/(12*n));
    }
}
