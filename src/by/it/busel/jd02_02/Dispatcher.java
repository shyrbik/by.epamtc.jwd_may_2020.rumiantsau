package by.it.busel.jd02_02;

class Dispatcher {
    static final int SPEED_COEFFICIENT = 100;
    //todo maybe replace with  AtomicInteger
    private static int counterOfBuyersInside = 0;

    static synchronized int get() {
        return counterOfBuyersInside;
    }

    static synchronized void incrementNumberOfBuyers() {
        counterOfBuyersInside++;
    }

    static synchronized void decrementNumberOfBuyers() {
        counterOfBuyersInside--;
    }

}
