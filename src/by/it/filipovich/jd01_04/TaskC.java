package by.it.filipovich.jd01_04;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("1 3 4 6 3 11 6 3 7 8 2");
    }

    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        //InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length-1];
        int indexFirst = -1;
        int indexLast = -1;
        Helper.sort(array);
        //mergeSort(array);
        InOut.printArray(array, "V", 5);

        indexFirst = binarySearch(array, first);
        indexLast = binarySearch(array, last);

        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast);
    }

    /**
     *
     * @param array входной массив для поиска элемента
     * @param value искомый ээлемент
     * @return возвращает искомый элемент
     */
    private static int binarySearch(double[] array, double value) {
        int low = 0;
        int end = array.length-1;
        int mid = (low+end)/2;
        while(array[mid] != value) {
            if (array[mid] > value)
                end = mid - 1;
            else if (value > array[mid])
                low = mid + 1;

                mid = (low + end) / 2;
        }
            return mid;

    }

    /**
     *
     * @param array начальный входной массив для сортировки
     */
    static void mergeSort(double[] array){
        System.out.println("Массив до сортировки:");
        InOut.printArray(array,"V",4);
        mergeSort(array, 0, array.length-1);
        System.out.println("Массив после сортировки:");
        InOut.printArray(array,"V",4);
    }

    /**
     *
     * @param array входной массив для разбиения
     * @param left индекс начального элемента разбиваемого отрезка
     * @param right индекс конечного элемента разбиваемого отрезка
     */
    private static void mergeSort(double[] array, int left, int right) {
        if(left == right)
            return;
        //int i = 0;
        //int j = 0;

        int mid = (right-left)/2;
        double[] part1 = new double[mid];
        double[] part2 = new double[right-mid];
        for(int i = 0; i < mid; i++){
            part1[i] = array[i];
        }
        for(int j = mid; j < right; j++){
            part2[j] = array[j];
        }

        mergeSort(part1, 0, mid-1);
        mergeSort(part2, mid, right);
        merge(part1, part2);
    }


    private static double[] merge(double[] part1, double[] part2){
        int allLength = part1.length+part2.length;
        double[] array = new double[allLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < part1.length && j < part2.length){
            if(part1[i] < part2[j]) {
                array[k] = part1[i];
                i++;
            }
            else {
                array[k] = part2[j];
                j++;
            }
        }
        while(i < part1.length) {
            array[k] = part1[i];
            i++;
            k++;
        }
        while(j < part2.length) {
            array[k] = part2[j];
            j++;
            k++;
        }
        return array;
    }




}
