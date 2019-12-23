package by.it.kuzmichalex.jd01_02;

import java.util.Scanner;

public class TaskA {
    //Поиск самого маленького и самого большого элементов массива
    public static void step1(int[] mas) {
        if (mas.length < 1) {
            System.out.println("step2 Возмущён: Ну и массив! сами его шерстите!");
            return;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < minValue) minValue = mas[i];
            if (mas[i] > maxValue) maxValue = mas[i];
        }
        System.out.print(minValue + " " + maxValue);
        System.out.println();
    }

    //Вывод на консоль строго меньших элементов массива
    public static void step2(int[] mas) {
        if (mas.length < 1) {
            System.out.println("step2 Возмущён: Ну и массив! сами его шерстите!");
            return;
        }

        double midValue = 0.0;
        for (int i = 0; i < mas.length; i++) {
            midValue += (double) mas[i];
        }
        midValue /= (double) mas.length;

        for (int i = 0; i <mas.length; i++) {
            if ((double) mas[i] < midValue) {
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println();
    }

    //вывод на консоль индексов самых маленьких элементов массива, в обратном порядке
    public static void step3(int[] mas) {
        if (mas.length < 1) {
            System.out.println("step2 Возмущён: Ну и массив! сами его шерстите!");
            return;
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < minValue) {
                minValue = mas[i];
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == minValue) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr=new int[10];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }
}
