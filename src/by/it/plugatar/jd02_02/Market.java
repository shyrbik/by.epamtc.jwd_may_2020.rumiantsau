package by.it.plugatar.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        System.out.println("-----------Market opened");
        List<Thread> threads = new ArrayList<>(1000);

        for (int i = 0; i<= 120; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
      //      int countBuyer= RandomHelper.random(0,2);

        for (int i = 1; i < 10000; i++) {
            Buyer buyer = new Buyer(i);
            //buyers.add(buyer);
            buyer.start();
        }
        /*
        for (Buyer buyer:buyers){
            try{
                byuer.join();
            }
            catch (InterruptedException e){
                System.out.println("Uncorrected join");
            }
        }
        System.out.println("-----------Market closed");
    }
    */
    }
}
