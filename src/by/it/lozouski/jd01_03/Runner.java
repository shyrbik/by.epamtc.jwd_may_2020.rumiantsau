package by.it.lozouski.jd01_03;

import java.util.Scanner;

/**
 * В этом классе производится проверка методов в классах {@link InOut} и {@link Helper} на корректность ввода\вывода и расчета.
 */
class Runner {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите массив чисел в виде строки, через пробел:");
        String str = sc1.nextLine();
        double[] arr = InOut.getArray(str);
        System.out.println("Проверка вывода массива полученного из строки:");
        InOut.printArray(arr);
        System.out.println("Проверка вывода массива при помощи printf:");
        InOut.printArray(arr, "TEST", 4);

        double min = Helper.findMin(arr);
        double max = Helper.findMax(arr);
        System.out.println("Макс. значение в массиве: " + max +'\n'+"Мин. значение в массиве: " + min);
        Helper.sort(arr);
        System.out.println("Проверка вывода отсортированного массива: ");
        InOut.printArray(arr);

        double[][] matrix = Helper.matrixBuilderRandom(5);
        double[] mulMatrixAndVector = Helper.mul(matrix, arr);
        System.out.println("Проверка результата умножения матрицы на вектор: ");
        InOut.printArray(mulMatrixAndVector);
        double[][] mulMatrixAndMatrix = Helper.mul(matrix, matrix);
        System.out.println("Проверка результата умножения матрицы на матрицу:");
        InOut.printMatrix(mulMatrixAndMatrix);
    }
}
