package by.it.popkov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        List<Thread> manInMarket = new ArrayList<>(6000);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            manInMarket.add(thread);
            thread.start();
        }

        Administrator administrator = new Administrator();
        administrator.start();

        int counter = 1;
        int letIn = 0;
        while (Dispatcher.planIsNotCompleted()) {
            letIn = Helper.randNumUntil(2);
            for (int j = 1; j <= letIn; j++) {
                if (Dispatcher.planIsNotCompleted()) {
                    Buyer buyer = new Buyer(counter++);
                    buyer.start();
                    manInMarket.add(buyer);
                }
            }
            Helper.delay(1000);
        }

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

