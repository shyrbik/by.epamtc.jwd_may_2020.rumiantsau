package by.it.busel.jd02_01;
/*
Yes, I know that code duplication doesn't conform to Java Code Conventions,
but for the purposes of examinations of Tasks I creates three classes, which
are shops equivalents with different "shop logic"
 */

import java.util.ArrayList;
import java.util.List;

class ShopA {

    private static List<Buyer> subThreads = new ArrayList<>(200);

    public static void main(String[] args) {
        String currentThreadName = ShopA.class.getSimpleName();
        System.out.println("<<<<< " + currentThreadName + " has opened >>>>>");
        int buyerId = 0;
        for (int second = 0; second <= 120; second++) {
            int numberOfBuyersToEnterTheShop = Helper.getRandomIntValue(0, 2);
            for (int i = 0; i < numberOfBuyersToEnterTheShop; i++) {
                Buyer buyer = new Buyer(++buyerId);
                subThreads.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        executeUntilAllSubThreadsFinished();
        System.out.println("<<<<< " + currentThreadName + " has closed >>>>>");
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

// Unnecessary code fragments:
// System.out.println("The current thread \"" + currentThreadName + "\" has started.");
// System.out.println("The current thread \"" + currentThreadName + "\" has successfully ended.");
