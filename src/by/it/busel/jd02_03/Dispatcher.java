package by.it.busel.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//todo maybe replace with  AtomicInteger
class Dispatcher extends Thread {
    static final int SPEED_COEFFICIENT = 100;
    private static final int MAX_DAILY_BUYERS_NUMBER = 100;
    private static final int CASHIER_COUNTERS_AVAILABLE = 5;

    private static AtomicInteger counterOfBuyersServedToday = new AtomicInteger(0);
    private static AtomicInteger counterOfBuyersInside = new AtomicInteger(0);

    static boolean shopDoorsAreStillOpened() {
        return counterOfBuyersServedToday.get() < MAX_DAILY_BUYERS_NUMBER;
    }

    static boolean shopCanBeClosed() {
        return counterOfBuyersServedToday.get() == MAX_DAILY_BUYERS_NUMBER
                && counterOfBuyersInside.get() == 0;
    }

    static int getBuyersNumberInside() {
        return counterOfBuyersInside.get();
    }

    static void buyerEntered() {
        counterOfBuyersServedToday.getAndIncrement();
        counterOfBuyersInside.getAndIncrement();
    }

    static void buyerLeft() {
        counterOfBuyersInside.getAndDecrement();
    }

    private static AtomicInteger counterOfOpenedCashiers = new AtomicInteger(0);

    private static final Object cashiersMonitor = new Object();

    private static boolean needsCashierToOpenTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.class) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers.get()) {
                    case 0:
                        return quantityOfBuyersInAQueue > 0;
                    case 1:
                        return quantityOfBuyersInAQueue > 5;
                    case 2:
                        return quantityOfBuyersInAQueue > 10;
                    case 3:
                        return quantityOfBuyersInAQueue > 15;
                    case 4:
                        return quantityOfBuyersInAQueue > 20;
                    case 5:
                        return false;
                }
            }
        }
        return false;
    }

    static boolean saysCashierToCloseTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.queueMonitor) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers.get()) {
                    case 1:
                        return quantityOfBuyersInAQueue == 0;
                    case 2:
                        return quantityOfBuyersInAQueue <= 5;
                    case 3:
                        return quantityOfBuyersInAQueue <= 10;
                    case 4:
                        return quantityOfBuyersInAQueue <= 15;
                    case 5:
                        return quantityOfBuyersInAQueue <= 20;
                    default:
                        return false;
                }
//                if (counterOfOpenedCashiers == 1) {
//                    return false;
//                } else if (counterOfOpenedCashiers == 2 && quantityOfBuyersInAQueue <= 5) {
//                    return true;
//                } else if (counterOfOpenedCashiers == 3 && quantityOfBuyersInAQueue <= 10) {
//                    return true;
//                } else if (counterOfOpenedCashiers == 4 && quantityOfBuyersInAQueue <= 15) {
//                    return true;
//                } else return counterOfOpenedCashiers == 5 && quantityOfBuyersInAQueue <= 20;
            }
        }
    }

    static int getCashiersNumberWorking() {
        return counterOfOpenedCashiers.get();
    }

    static void cashierOpensTheCounter() {
        counterOfOpenedCashiers.getAndIncrement();
    }

    static void cashierClosesTheCounter() {
        counterOfOpenedCashiers.getAndDecrement();
    }

    private static int cashierId = 0;

    private static List<Cashier> cashiersThreads = new ArrayList<>(5);

    private static void addCashiers() {
        for (int i = 1; i <= 2; i++) {
            cashierId = i;
            Cashier cashier = new Cashier(cashierId);
            cashiersThreads.add(cashier);
            cashier.start();
        }
    }

    @SuppressWarnings("all")
    private static void makeCashierWork() {
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

    @SuppressWarnings("all")
    private static void checkIfCasiersStillAtWorkAndSendThemHome() {
        for (Cashier cashier : cashiersThreads) {
            if (!cashier.getState().name().equals("TERMINATED")) {
                synchronized (cashier) {
                    cashier.interrupt();
                }
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

    @Override
    public void run() {
        addCashiers();
        while (!Dispatcher.shopCanBeClosed())
            while (Dispatcher.needsCashierToOpenTheCounter()) {
                makeCashierWork();
            }
        checkIfCasiersStillAtWorkAndSendThemHome();
        executeUntilAllCashiersFinished();
    }
}
