package by.it.kuzmichaa.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 2);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);
        for (double arr : array) System.out.print(arr + " ");
        System.out.println();

        double [][] matrix = {
                {1, 2, 3},
                {3, 2, 0},
                {1, 5, 3},
        };

        double [] vector = {5, 3, 2};
        Helper.mul(matrix, vector);


    }
}
