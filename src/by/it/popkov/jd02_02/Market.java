package by.it.popkov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        List<Buyer> buyerList = new ArrayList<>(1777);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier();
            Thread thread = new Thread(cashier, "Cashier " + i);
        }
        int counter = 1;
        int letIn = 0;
        for (int t = 0; t < 120; t++) {
            letIn = Helper.randNumUntil(2);
            for (int j = 1; j <= letIn; j++) {
                Buyer buyer = new Buyer(counter++);
                buyer.start();
                buyerList.add(buyer);
            }
            Helper.delay(1000);
            //            System.out.println("Sec = " + t + "Count = " + Dispatcher.buyerCounter);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("****** Close shop ******");

    }
}

