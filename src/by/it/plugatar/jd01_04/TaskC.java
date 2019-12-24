package by.it.plugatar.jd01_04;

import java.util.Scanner;

public class TaskC {
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
    static void buildOneDimArray(String line){
        double [] array= by.it.plugatar.jd01_03.InOut.getArray(line);
        double first=array[0];
        double last = array[array.length-1];
        by.it.plugatar.jd01_03.InOut.printArray(array,"V",5);//2-ой пункт
        by.it.plugatar.jd01_03.Helper.sort(array);//3-ий пункт
        by.it.plugatar.jd01_03.InOut.printArray(array,"V",4);//4-ий пункт
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==first) System.out.println("first element="+i);//break;//indexFirst=i;
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==last) System.out.println("last element="+i);//break;//indexLast=i;
        }
        String name = "V";
        by.it.plugatar.jd01_03.InOut.printArray(array, name, 5);
        //double first = array[0];
       // double last = array[array.length - 1];
        mergeSort(array);
        by.it.plugatar.jd01_03.InOut.printArray(array, name, 4);

    }

    private static void mergeSort(double[] array) {
        int m = array.length / 2;
        mergeSort(array, 0, m - 1);
        mergeSort(array, m, array.length - 1);
        double[] array1 = new double[m];
        double[] array2 = new double[array.length - m];
        System.arraycopy(array,0,array1,0,array1.length);
        System.arraycopy(array, m, array2, 0, array2.length);
        double[] array3 = merge(array1, array2);
        System.arraycopy(array3,0,array,0,array.length);
    }
    private static void mergeSort(double[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            double[] array1 = new double[m - l + 1];
            double[] array2 = new double[r - m];
            System.arraycopy(array, l, array1, 0, array1.length);
            System.arraycopy(array, m+1, array2, 0, array2.length);
            double[] array3 = merge(array1, array2);
            System.arraycopy(array3, 0, array, l, array3.length);
        }
    }
    private static double[] merge(double[] part1, double[] part2) {
        double[] res = new double[part1.length + part2.length];
        int k = 0, l = 0;
        for (int i = 0; i < res.length; i++)
            if (k < part1.length && l < part2.length) {
                if (part1[k] < part2[l]) {
                    res[i] = part1[k];
                    k++;
                } else {
                    res[i] = part2[l];
                    l++;
                }
            } else if (k == part1.length) {
                res[i] = part2[l];
                l++;
            } else {
                res[i] = part1[k];
                k++;
            }
        return res;
    }
}
