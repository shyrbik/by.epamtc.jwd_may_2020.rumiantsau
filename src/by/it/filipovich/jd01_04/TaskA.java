package by.it.filipovich.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    /**
     * метод печатает таблицу умножения в заданном формате
     */
    private static void printMulTable(){
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d",i, j, i*j);
            }
            System.out.println();
        }
    }

    /**
     * метод преобразует строку в массив чисел
     * выводит массив на экран,после чего сортирует его и снова выводит на экран
     * после этого выводит текущие индексы 1-го и последнего элемента первоначального массива.
     * @param line строка из чисел,записанных через пробел.
     */
    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length-1];
        int indexFirst = -1;
        int indexLast = -1;
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == first)
                indexFirst = i;
            if(array[i] == last)
                indexLast = i;
        }
        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast);
    }

}
