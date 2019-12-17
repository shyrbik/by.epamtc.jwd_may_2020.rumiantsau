package by.it.popkov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
            if (max < array[i]) max = array[i];
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        double avr = 0;
        for (int i : array) {
            avr+=i;
        }
        avr/=array.length;
        for (int i : array) {
            if(i < avr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    private static void step3(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min){
                System.out.print(i + " ");
            }
        }
    }



}
