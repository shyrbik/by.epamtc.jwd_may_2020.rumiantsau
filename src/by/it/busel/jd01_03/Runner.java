package by.it.busel.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String lineTaskA = "0.1 0.2 -0.2 -0.1 2.2 12.34 21.3 -456.1";
        double[] doublesFromAStringLineTaskA = InOut.getArray(lineTaskA);
        InOut.printArray(doublesFromAStringLineTaskA);
        InOut.printArray(doublesFromAStringLineTaskA, "double", 5);
        System.out.println("Hello, World!");

        double[] doublesTaskB = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100000000};
        double maximum = Helper.findMax(doublesTaskB);
        double minimum = Helper.findMin(doublesTaskB);
        Helper.sort(doublesTaskB);

        double[][] matrixC1 = new double[][]{
                {1, 2, 3, 4, 5, 6, 7, 8,},
                {9, 10, 11, 12, 13, 14, 15, 16,},
                {17, 18, 19, 20, 21, 22, 23, 24,},
                {25, 26, 27, 28, 29, 30, 31, 32}
        };
        double[] vector = new double[]{1, 2, 3, 4, 5, 6, 7, 8};
        double[][] matrixC2 = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21}};
        double[] mulTaskC1 = Helper.mul(matrixC1, vector);
        double[][] mulTaskC2 = Helper.mul(matrixC1, matrixC2);
    }
}
