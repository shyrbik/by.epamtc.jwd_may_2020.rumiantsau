package by.it.samuseva.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>(10);

        System.err.println("-----------THE MARKET HAS OPENED-----------");

        for (int i = 1; i <= 10; i++) {
            Buyer buyer = new Buyer(i);
            buyer.start();
            buyers.add(buyer);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("YPS !!!");
            }
        }
        System.err.println("-----------THE MARKET HAS CLOSED-----------");
    }
}
