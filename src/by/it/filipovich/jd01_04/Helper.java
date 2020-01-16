package by.it.filipovich.jd01_04;

import java.util.Arrays;

public class Helper {

    static double[] sort(double[] arr) {
        double temp;
        int iter = arr.length - 1;
        while (iter > 0) {
            for (int i = 0; i < iter; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            iter--;
        }
        //InOut.printArray(sortArray,"V", 4);
        return arr;
    }
}
