package by.it.plugatar.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        System.out.println("-----------Market opened");
        List<Buyer> buyers = new ArrayList<>(1000);
        for (int time = 0; time <= 120; time++) {
            int countBuyer=RandomHelper.random(0,2);
        }
        for (int i = 1; i < 10000; i++) {
            Buyer buyer = new Buyer(i);
            buyers.add(buyer);
            buyer.start();
        }
        for (Buyer byuer:buyers){
            try{
                byuer.join();
            }
            catch (InterruptedException e){
                System.out.println("Uncorrected join");
            }
        }
        System.out.println("-----------Market closed");
    }
}
