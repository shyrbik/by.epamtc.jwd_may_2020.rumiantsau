package by.it.popkov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        List<Thread> manInMarket = new ArrayList<>(6000);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
//            manInMarket.add(thread);
//            thread.start();
        }
        int counter = 1;
        int letIn = 1;
        for (int t = 0; t < 5000; t++) {
//            letIn = Helper.randNumUntil(2);
            for (int j = 1; j <= letIn; j++) {
                Buyer buyer = new Buyer(counter++);
                buyer.start();
                manInMarket.add(buyer);
            }
            Helper.delay(1000);
            //            System.out.println("Sec = " + t + "Count = " + Dispatcher.buyerCounter);
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SIZE queue" + BuyerQueue.buyerQueue.size());
        for (Thread man : manInMarket) {
            try {
                man.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("****** Close shop ******");

    }
}

