package by.it.borodachev.jd01_04;
import java.util.Scanner;
public class TaskC {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String line;
        line=inp.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] mas=InOut.getArray(line);
        double minValue,maxValue;

        InOut.printArray(mas,"V",5);
        minValue=mas[0];
        maxValue=mas[mas.length-1];
        mergeSort(mas);
        InOut.printArray(mas,"V",4);

        System.out.println("Index of first element="+binarySearch(mas,minValue));
        System.out.println("Index of last element="+binarySearch(mas,maxValue));

    }

    private static int binarySearch(double[] mas, double elem) {
        int left,right,midd;
        left=0;
        right=mas.length-1;
        while (left<=right){
            midd=(left+right)/2;
            if(mas[midd]==elem) return midd;
            else if(mas[midd]>elem) right=midd-1;
            else left=midd+1;
        }
        return -1;
    }

    static void mergeSort(double[] mas) {
        mergeSort(mas, 0, mas.length - 1);
    }

    static void mergeSort(double[] mas, int left, int right) {
        if (mas.length == 0) return;
        if (left >= right) return;
       double median = mas[(left + (right - left) / 2)];
         int i = left, j = right;
        while (i <= j) {
            while (mas[i] < median) {
                i++;
            }
            while (mas[j] > median) {
                j--;
            }
            if (i <= j) {
                double tmp = mas[i];
                mas[i] = mas[j];
                mas[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) mergeSort(mas, left, j);
        if (right > i) mergeSort(mas, i, right);
    }
}
