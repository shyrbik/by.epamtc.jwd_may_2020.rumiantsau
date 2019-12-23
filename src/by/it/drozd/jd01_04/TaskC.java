package by.it.drozd.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("321342 12312323 123 21 3");
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == start) {
//                System.out.println("Index of first element=" + i);
//                break;
//            }
//            for (int j = 0; j < array.length; j++) {
//                if (array[i] == last) {
//                    System.out.println("Index of last element=" + i);
//                    break;
//                }
//            }
//        }
        System.out.println("first element=" + binarySearch(array, start));
        System.out.println("last element=" + binarySearch(array, last));
    }

    static void mergeSort(double[] array) {
        Arrays.sort(array);
    }

    static int binarySearch(double[] array, double value) {
        int a=Arrays.binarySearch(array,value);
        return a;

    }

}
