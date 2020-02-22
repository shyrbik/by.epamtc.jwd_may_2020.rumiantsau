package by.it.plugatar.jd02_01;

import java.util.Random;

public class RandomHelper {
    private static Random generator = new Random(System.nanoTime());
    static void sleep (int min, int max){
        int timeout = (min+generator.nextInt(max-min+1)/Dispatcher.K_SPEED);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.err.println("WOW!!!");
        }
    }
    static void sleep(int max){
        sleep(0,max);
    }
    static int random(int min, int max){
        return min+generator.nextInt(max-min+1);
    }
    static int random(int max){
        return max+generator.nextInt(max+1);
    }
}
