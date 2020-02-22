package by.it.busel.jd02_02;

//todo maybe replace with  AtomicInteger
class Dispatcher {
    static final int SPEED_COEFFICIENT = 100;
    private static final int MAX_DAILY_BUYERS_NUMBER = 100;

    private static final Object magicWand = new Object();

    private static int counterOfBuyersServedToday = 0;
    private static int counterOfBuyersInside = 0;

    static boolean shopDoorsAreStillOpened() {
        synchronized (magicWand) {
            return counterOfBuyersServedToday < MAX_DAILY_BUYERS_NUMBER;
        }
    }

    static boolean shopCanBeClosed() {
        synchronized (magicWand) {
            return counterOfBuyersServedToday == MAX_DAILY_BUYERS_NUMBER && counterOfBuyersInside == 0;
        }
    }

    static int getBuyersNumberInside() {
        synchronized (magicWand) {
            return counterOfBuyersInside;
        }
    }

    static void buyerEntered() {
        synchronized (magicWand) {
            counterOfBuyersServedToday++;
            counterOfBuyersInside++;
        }
    }

    static void buyerLeft() {
        synchronized (magicWand) {
            counterOfBuyersInside--;
        }
    }
}
