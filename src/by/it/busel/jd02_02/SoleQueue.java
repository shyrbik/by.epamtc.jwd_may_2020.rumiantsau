package by.it.busel.jd02_02;

import java.util.ArrayDeque;

class SoleQueue {

    static final Object queueMonitor = new Object();

    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void add(Buyer buyer) {
        synchronized (queueMonitor) {
            queue.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (queueMonitor) {
            return queue.pollFirst();
        }
    }

    static int getBuyersQuantity() {
        synchronized (queueMonitor) {
            return queue.size();
        }
    }

}
