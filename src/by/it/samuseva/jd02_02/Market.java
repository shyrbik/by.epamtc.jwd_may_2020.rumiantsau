package by.it.samuseva.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        new Good();
        List<Thread> threads = new ArrayList<>(1000);

        System.err.println("-----------THE MARKET HAS OPENED-----------");
        for (int i = 1; i <= Dispetcher.getCountCasher(); i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        int number = 0;
        while (Dispetcher.marketOpened()){
            int count = Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                if (Dispetcher.marketOpened()){
                    Buyer buyer = new Buyer(++number);
                    if (number%4 == 0) {
                        buyer.pensioner = true;
                        System.err.println(number%4);
                    }
                    threads.add(buyer);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }

        for (Thread  buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("YPS !!!");
            }
        }
        System.err.println("-----------THE MARKET HAS CLOSED-----------");
    }
}
