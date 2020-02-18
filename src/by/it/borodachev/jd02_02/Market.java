package by.it.borodachev.jd02_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Market {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        List<Buyer> buyers=new ArrayList<>(1000);
        Dispatcher.buyer2Cash=new PriorityQueue<>();
        Cashier c=new Cashier(1);
        c.setDaemon(true);
        c.start();

        Cashier c2=new Cashier(2);
        c2.setDaemon(true);
        c2.start();
        int number=0;
        for (int time = 0; time <= 2; time++) {
            int count= Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        while (Dispatcher.buyerCount()!=0) {Helper.sleep(1000);}
            for (Buyer buyer : buyers) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("WOW2");
                }
            }

        System.out.println("--------- Market closed");
    }

}
