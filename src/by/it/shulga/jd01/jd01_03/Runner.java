package by.it.shulga.jd01.jd01_03;
/**
 * @author Vadim
 */

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array =  InOut.getArray(str);
        double[ ][ ] matrix = {
                {5, 4, 7, 8},
                {5, 9, 3, 7},
                {8, 4, 9, 5},
                {9, 2, 1, 7}
        };
        double[ ] vector = { 6, 7, 5, 3};

        double[ ][ ] matrixLeft = {
                {5, 4, 7, 8},
                {5, 9, 3, 7},
                {8, 4, 9, 5},
                {9, 2, 1, 7}
        };
        double[ ][ ] matrixRight ={
                {5, 4, 7, 8},
                {5, 9, 3, 7},
                {8, 4, 9, 5},
                {9, 2, 1, 7}
        };

        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.mul(matrix, vector);
        Helper.mul(matrixLeft,matrixRight);

    }
}