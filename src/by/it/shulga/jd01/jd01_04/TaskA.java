package by.it.shulga.jd01.jd01_04;

import java.util.Scanner;

public class TaskA {

    static void printMulTable() {         //создаем таблицу умножения
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }


    }

    static void buildOneDimArray(String line) {
     double[] array = InOut.getArray(line);      // из класса InOut вызывается getArray(line) и присваевается double[] array
        double start = array[0];                        // первый элемент массива
        double stop = array[array.length-1];               // последний элемент массива
        InOut.printArray(array,"V",5);   //вывод в 5 колонок

        System.out.println();
        Helper.sort(array);         // вызвали из Helper. и передаем на сортировку массив
        InOut.printArray(array,"V",4);      //вывод в 4 колоноки

        for (int i = 0; i < array.length; i++) {    //перебор элементов массива
            if (array[i] == start) {     // если array[i] =start то
                System.out.println("Index of first element="+i);   // напечатать индекс(порядковый номер в массиве) первого элемента
                break;      //прерывание цикла.
            }
        }
        for (int i = 0; i < array.length; i++) {    // аналогично для последнего элемента.
            if (array[i] == stop) {
                System.out.println("Index of last element="+i);
                break;
            }
        }

     }





    public static void main(String[] args) {
        printMulTable();                 // вызываем метод printMulTable

        Scanner scan = new Scanner(System.in); // вызов сканера строки.
        String s = scan.nextLine();
       buildOneDimArray(s);  // вызываем методпередаем туда s

    }



}