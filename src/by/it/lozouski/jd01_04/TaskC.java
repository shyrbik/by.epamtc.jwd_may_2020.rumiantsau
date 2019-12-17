package by.it.lozouski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String line = sc1.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element=" + Arrays.binarySearch(array, first));
        System.out.println("Index of last element=" + Arrays.binarySearch(array, last));
    }

    public static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length-1);
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (array == null) {
            return;
        }
        if (array.length < 2) {
            return;
        }
        double[] l = new double[array.length / 2];
        double[] r = new double[array.length - (array.length / 2)];
        System.arraycopy(array, 0, l, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, r, 0, array.length - (array.length / 2));
        mergeSort(l,0,l.length-1);
        mergeSort(r,0,r.length-1);
        array = merge(l, r);
    }

    private static double[] merge(double[] arrayA, double[] arrayB) {
        double[] arrayC = new double[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }
//        double[] resArray = new double[part1.length + part2.length];
//        double n = part1.length;
//        double m = part2.length;
//        int i = 0, j = 0, k = 0;
//        while (i < n && j < m) {
//            if (part1[i] <= part2[j]) {
//                resArray[k] = part1[i];
//                i++;
//            } else {
//                resArray[k] = part2[j];
//                j++;
//            }
//            while (i < n) {
//                resArray[k] = part1[i];
//                i++;
//                k++;
//            }
//            while (j < m) {
//                resArray[k] = part2[j];
//                j++;
//                k++;
//            }
//        }
//        return resA
}
