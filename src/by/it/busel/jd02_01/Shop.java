package by.it.busel.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {

    private static List<Buyer> subThreads = new ArrayList<>(200);

    public static void main(String[] args) {
        String mainThreadName = Shop.class.getSimpleName();
        System.out.println("<<<<< The \"" + mainThreadName + "\" has opened >>>>>");
        int buyerId = 0;
        for (int second = 0; second <= 120; second++) {
            int numberOfBuyersToEnterTheShopInOneSecond = Helper.getRandomIntValue(0, 2);
            for (int i = 0; i < numberOfBuyersToEnterTheShopInOneSecond; i++) {
                Buyer buyer = new Buyer(++buyerId);
                subThreads.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        System.out.println("===== The dispatcher of the \"" + mainThreadName + "\" has shut the doors =====");
        executeUntilAllSubThreadsFinished();
        System.out.println("<<<<< The \"" + mainThreadName + "\" has closed >>>>>");
    }

    private static void executeUntilAllSubThreadsFinished() {
        for (Buyer buyer : subThreads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}