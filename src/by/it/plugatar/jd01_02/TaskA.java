package by.it.Plugatar.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // String line =sc.nextLine();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();//scanner.NextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    public static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
            if (max < array[i]) max = array[i];

        }
        System.out.println(min + " " + max);
    }

    public static void step2(int[] array) {
        double avg = 0;
        for (int value : array) {
           // avg /= array.length;
            avg=avg+value;
        }
        avg=avg/array.length;
        for (int value : array) {
            if (value < avg) {
                System.out.print(value + " ");
            }
        }
    }


    public static void step3(int[] array) {
        int min=array[0];
        //int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if (min>array[i]) min=array[i];
          //  if (max<array[i]) max=array[i];

        }
        for (int i = array.length - 1; i >= 0; i--) {
           if (array[i]== min){
                System.out.print(i + " ");
            }

        }
        //System.out.println(min+" "+max);
    }
}
