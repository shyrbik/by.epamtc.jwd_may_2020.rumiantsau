package by.it.busel.jd01_03;

import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        String lineTaskA = "0.1 0.2 -0.2 -0.1 2.2 12.34 21.3 -456.1";
        double[] doublesFromAStringLineTaskA = InOut.getArray(lineTaskA);
        InOut.printArray(doublesFromAStringLineTaskA);
        InOut.printArray(doublesFromAStringLineTaskA, "double", 5);
        System.out.println("Hello, World!");
    }
}
