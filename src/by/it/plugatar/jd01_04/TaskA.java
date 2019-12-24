package by.it.plugatar.jd01_04;

import by.it.plugatar.jd01_03.Helper;
import by.it.plugatar.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String s =sc.nextLine();
        buildOneDimArray(s);
    }


    static void printMulTable(){
        for (int i = 2; i <=9 ; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println(" ");
        }
    }

//формирует из строки line массив вещественных чисел, (можно скопировать для этого класс InOut, написанныйв jd01_03Задание A)
//выводит в 5 колонок этот массив с названием Vи индексами (тоже InOut), например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
//сортирует этот массив по возрастанию (см. Helper.sortв jd01_03Задание B)
//еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
//выполняет вычисление новых (после сортировки) индексов первого и последнего элемента исходного массива и печатает их в виде:
//Index of first element=2
//Index of last element=7
//2 1 3 4 5 6 7 9 8
    static void buildOneDimArray(String line){
        double [] array= InOut.getArray(line);
        double first=array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V",5);//2-ой пункт
        Helper.sort(array);//3-ий пункт
        InOut.printArray(array,"V",4);//4-ий пункт
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==first) System.out.println("first element="+i);//break;//indexFirst=i;
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==last) System.out.println("last element="+i);//break;//indexLast=i;
        }
        //System.out.printf("first element=%d\n", Arrays.binarySearch(array,first));
        //System.out.printf("last element=%d\n", Arrays.binarySearch(array,last));


    /*
        int indexFirst=-1;
        int indexLast=-1;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==first) indexFirst=i;
            if (array[i]==last)  indexLast=i;
        }
       */
    }

}
