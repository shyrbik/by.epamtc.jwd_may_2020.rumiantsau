package by.it.popkov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        List<Buyer> buyerList = new ArrayList<>(1777);
        int counter = 1;
        for (int i = 0; i < 120; i++) {
            for (int j = 1; j <= Helper.randNumUntil(2); j++) {
                Buyer buyer = new Buyer(counter++);
                buyer.start();
                buyerList.add(buyer);
            }
            try {
                Thread.sleep(1000 / Dispatcher.SPEED_BOOST);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
