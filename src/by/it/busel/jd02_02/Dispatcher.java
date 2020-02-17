package by.it.busel.jd02_02;

//todo maybe replace with  AtomicInteger
class Dispatcher {
    static final int SPEED_COEFFICIENT = 100;
    private static final int MAX_DAILY_BUYERS_NUMBER = 100;
    private static final int CASHIER_COUNTERS_AVAILABLE = 5;

    private static final Object buyersMonitor = new Object();

    private static int counterOfBuyersServedToday = 0;
    private static int counterOfBuyersInside = 0;

    static boolean shopDoorsAreStillOpened() {
        synchronized (buyersMonitor) {
            return counterOfBuyersServedToday < MAX_DAILY_BUYERS_NUMBER;
        }
    }

    static boolean shopCanBeClosed() {
        synchronized (buyersMonitor) {
            return counterOfBuyersServedToday == MAX_DAILY_BUYERS_NUMBER && counterOfBuyersInside == 0;
        }
    }

    static int getBuyersNumberInside() {
        synchronized (buyersMonitor) {
            return counterOfBuyersInside;
        }
    }

    static void buyerEntered() {
        synchronized (buyersMonitor) {
            counterOfBuyersServedToday++;
            counterOfBuyersInside++;
        }
    }

    static void buyerLeft() {
        synchronized (buyersMonitor) {
            counterOfBuyersInside--;
        }
    }

    private static int counterOfOpenedCashiers = 0;

    private static final Object cashiersMonitor = new Object();

    static boolean needsCashierToOpenTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.class) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers) {
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
//                if (quantityOfBuyersInAQueue <= 5 && counterOfOpenedCashiers == 1) {
//                    return false;
//                } else if (quantityOfBuyersInAQueue <= 10 && counterOfOpenedCashiers == 2) {
//                    return false;
//                } else if (quantityOfBuyersInAQueue <= 15 && counterOfOpenedCashiers == 3) {
//                    return false;
//                } else if (quantityOfBuyersInAQueue <= 20 && counterOfOpenedCashiers == 4) {
//                    return false;
//                } else if (quantityOfBuyersInAQueue >= 21 && counterOfOpenedCashiers == 5) {
//                    return false;
//                }
            }
        }
        return false;
    }

    static boolean saysCashierToCloseTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.class) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers) {
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
        synchronized (cashiersMonitor) {
            return counterOfOpenedCashiers;
        }
    }

    static void cashierOpensTheCounter() {
        synchronized (cashiersMonitor) {
            counterOfOpenedCashiers++;
        }
    }

    static void cashierClosesTheCounter() {
        synchronized (cashiersMonitor) {
            counterOfOpenedCashiers--;
        }
    }

}
