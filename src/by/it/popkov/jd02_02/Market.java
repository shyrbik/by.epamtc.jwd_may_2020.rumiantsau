package by.it.popkov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    private List<Buyer> buyersInMarket = new ArrayList<>(1000);
    private List<Thread> cashierInMarket = new ArrayList<>(Dispatcher.CASHIER_MAX);

    public static void main(String[] args) {
        Market market = new Market();
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        market.letInCashier();
        market.letInAdministrator();
        market.letInBuyers();

        for (Buyer buyer : market.buyersInMarket) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread cashier : market.cashierInMarket) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("****** Close shop ******");

    }

    private void letInCashier() {
        for (int i = 1; i <= Dispatcher.CASHIER_MAX; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            cashierInMarket.add(thread);
            thread.start();
        }
    }

    private void letInAdministrator() {
        Administrator administrator = new Administrator();
        administrator.start();
    }

    private void letInBuyers() {
        int counter = 1;
        int letIn = 1;
        int sec = 1;
        while (Dispatcher.planIsNotCompleted()) {
            if ((Dispatcher.buyerOnline < sec % 60 && sec % 60 <= 30) || //UP
                    (Dispatcher.buyerOnline <= 40 + (30 - sec % 60) && sec % 60 > 30)) {   //DOWN
                letIn = Helper.randNumUntil(4);
                for (int j = 1; j <= letIn; j++) {
                    if (Dispatcher.planIsNotCompleted()) {
                        Buyer buyer = new Buyer(counter++);
                        buyer.start();
                        buyersInMarket.add(buyer);
                    }
                }
            }
            sec++;
            System.out.println("SEC = " + sec + " buyerOnline = " + Dispatcher.buyerOnline);
            Helper.delay(1000);

        }
    }
}

