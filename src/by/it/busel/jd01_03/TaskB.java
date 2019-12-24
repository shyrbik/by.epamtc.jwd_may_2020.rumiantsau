package by.it.busel.jd01_03;

public class TaskB {
    public static void main(String[] args) {
        double[] doublesTaskB = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100000000};
        double maximum = Helper.findMax(doublesTaskB);
        double minimum = Helper.findMin(doublesTaskB);
        Helper.sort(doublesTaskB);
    }
}
