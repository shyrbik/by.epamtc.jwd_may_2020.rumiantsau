package by.it.busel.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Shop {

    private static List<Buyer> buyersThreads = new ArrayList<>(1000);

    private static List<Cashier> cashiersThreads = new ArrayList<>(5);

    private static int buyerId = 0;

    private static int cashierId = 0;

    public static void main(String[] args) {
//        int thCount = Thread.activeCount();
        String mainThreadName = Shop.class.getSimpleName();
        informAboutOpening(mainThreadName);
        addCashiers(2);
        int second = 0;
        while (Dispatcher.shopDoorsAreStillOpened()) {
            int currentBuyersNumber = Dispatcher.getBuyersNumberInside();
            int numberOfBuyersToEnter = getNumberOfBuyersToEnter(second, currentBuyersNumber);
            System.out.println("Current second: " + second++ + "; Buyers inside the Shop: " + currentBuyersNumber
                    + "; Buyers to enter: " + numberOfBuyersToEnter);
            letBuyersGetIn(numberOfBuyersToEnter);
            while (Dispatcher.needsCashierToOpenTheCounter()) {
                boolean hasWaiting = false;
                for (Cashier cashier : cashiersThreads) {
                    if (cashier.getState().name().equals("WAITING")) {
                        synchronized (cashier) {
                            cashier.notify();
                            hasWaiting = true;
                            break;
                        }
                    }
                }
                if (cashiersThreads.size() < Dispatcher.CASHIER_COUNTERS_AVAILABLE && !hasWaiting) {
                    Cashier cashier = new Cashier(++cashierId);
                    cashiersThreads.add(cashier);
                    cashier.start();
                }
            }
//            while (Dispatcher.needsCashierToOpenTheCounter()) {
//                for (Cashier cashier : cashiersThreads) {
//                    if (cashier.getState().name().equals("WAITING")) {
//                        synchronized (cashier) {
//                            cashier.notify();
//                        }
//                    }
//                }
//            }
            Helper.sleep(1000);
        }
        informAboutDoorsClosure(mainThreadName);
//        executeUntilAllSubThreadsFinished(thCount);
        executeUntilAllBuyersFinished();
        for (Cashier cashier : cashiersThreads) {
            if (cashier.getState().name().equals("WAITING")) {
                synchronized (cashier) {
                    cashier.interrupt();
                }
            }
        }
        executeUntilAllCashiersFinished();
        informAboutClosureOfStore(mainThreadName);
    }

    private static void addCashiers(int number) {
        for (int i = 1; i <= number; i++) {
            cashierId = i;
            Cashier cashier = new Cashier(cashierId);
            cashiersThreads.add(cashier);
            cashier.start();
        }
    }

    private static int getNumberOfBuyersToEnter(int second, int currentBuyersNumber) {
        int numberOfBuyersToEnter;
        int simplifiedTimeUnit = second % 60;
//        int currentBuyersNumber = Dispatcher.get();
        if (simplifiedTimeUnit < 30) {
            numberOfBuyersToEnter = simplifiedTimeUnit + 10 - currentBuyersNumber;
        } else {
            numberOfBuyersToEnter = 40 + (30 - simplifiedTimeUnit) - currentBuyersNumber;
        }
        if (numberOfBuyersToEnter < 0) numberOfBuyersToEnter = 0;
        return numberOfBuyersToEnter;
    }

    private static void letBuyersGetIn(int numberOfBuyersToEnter) {
        for (int i = 0; i < numberOfBuyersToEnter; i++) {
            if (Dispatcher.shopDoorsAreStillOpened()) {
                Buyer buyer = new Buyer(++buyerId);
                buyersThreads.add(buyer);
                buyer.start();
            }
        }
    }

    private static void executeUntilAllCashiersFinished() {
        for (Cashier cashier : cashiersThreads) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void executeUntilAllBuyersFinished() {
        for (Buyer buyer : buyersThreads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        while (Thread.activeCount() > thCount) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static void informAboutOpening(String mainThreadName) {
        System.out.println("<<<<< The \"" + mainThreadName + "\" has opened >>>>>");
    }

    private static void informAboutDoorsClosure(String mainThreadName) {
        System.out.println("===== The dispatcher of the \"" + mainThreadName + "\" has shut the doors =====");
        System.out.println("===== A number of Buyers remaining inside the store is " + Dispatcher.getBuyersNumberInside() + " ======");
    }

    private static void informAboutClosureOfStore(String mainThreadName) {
        System.out.println("<<<<< The \"" + mainThreadName + "\" has closed >>>>>");
        System.out.println("===== A number of Buyers remaining inside the store is " + Dispatcher.getBuyersNumberInside() + " ======");
    }
}