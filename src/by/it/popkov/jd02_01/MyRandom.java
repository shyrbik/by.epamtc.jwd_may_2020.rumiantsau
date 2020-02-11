package by.it.popkov.jd02_01;

import java.util.Random;

class MyRandom {

    private static Random random = new Random(System.nanoTime());

    public static int randNum(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
    public static int randNumUntil(int max) {
        return randNum(0, max);
    }
}
