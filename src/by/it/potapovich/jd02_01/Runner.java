package by.it.potapovich.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countBuyers = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------- Market opened");
        Queue <Buyer> queue = new ArrayDeque<>();
        while (countBuyers < 10){
            Thread.sleep(1000);
            int count = Rnd.fromTo(0,2);
            for (int i =0; i <= count; i ++){
                countBuyers++;
                if (countBuyers < 120){
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }

            }

        }System.out.println("--------- Market closed");
    }
}
