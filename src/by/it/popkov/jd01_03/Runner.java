package by.it.popkov.jd01_03;


import java.util.Arrays;

class Runner {
    public static void main(String[] args) {
        double[] result = InOut.getArray(" 2 21 542 234 12 435 324 2 2349 120 34 ");
        System.out.println(Arrays.toString(result));
        InOut.printArray(result);
        InOut.printArray(result, "Array", 5);
        double min = Helper.findMin(result);
        double max = Helper.findMax(result);
        Helper.sort(result);
        System.out.println("Sort");
        System.out.println(Arrays.toString(result));
        double[][] matrix = new double[][]{{1.0, 2.0}, {3.0, 4.0}};
        double[] vector = new double[]{1.0, 2.0};
        System.out.println("Matrix * Vector");
        double[] c1 = Helper.mul(matrix, vector);
        System.out.println(Arrays.toString(c1));
        double[][] c2 = Helper.mul(matrix, matrix);
        System.out.println("Matrix * Matrix");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(c2[i]));
        }
    }
}
