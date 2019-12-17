package by.it.kuzmichalex.jd01_04;

import java.util.Scanner;

public class TaskA {
    /**
     * Вывод таблицы умножения
     */
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j <10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }
    /***
     * Поиск первого индекса элемента в массиве, чъё значние равно указанному
     * @param inArr массив, к котором производим поиск
     * @param  valueToSearch Значение,которе требуется найти
     * @return индекс елемента в массиве. Если елемент не найден, возвращается -1
     */
    static int getIndexOfElement(double[] inArr, double valueToSearch){
        for (int i = 0; i <inArr.length ; i++) {
            if(inArr[i]==valueToSearch)return i;
        }
        return -1;
    }

    /**
     * Формирование массива double из строки разделённых пробелами чисел
     * Используем InOut
     * */
    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V",5);
        double valueOfFirst=arr[0];
        double valueOfLast=arr[arr.length-1];
        Helper.sort(arr);
        InOut.printArray(arr, "V",4);
        System.out.println("Index of first element=" + getIndexOfElement(arr, valueOfFirst));
        System.out.println("Index of last element=" + getIndexOfElement(arr, valueOfLast));

    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc= new Scanner(System.in);
        String stringOfDoubles = sc.nextLine();
        buildOneDimArray(stringOfDoubles);
    }
}
