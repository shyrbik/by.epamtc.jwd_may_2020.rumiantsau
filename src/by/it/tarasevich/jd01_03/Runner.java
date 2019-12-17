package by.it.tarasevich.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        double[] arr = InOut.getArray(st);
        InOut.printArray(arr);
        InOut.printArray(arr, "M", 4);
        double min = Helper.findMin(arr);
        double max = Helper.findMax(arr);
        System.out.println(min + " " + max);
        Helper.sort(arr);
        double[] v={1,2,3};
        double[][] m={
                {2,3,4},
                {4,5,6}
        };
        double[] result = Helper.mul(m, v);
        System.out.println(Arrays.toString(result));
    }
}
