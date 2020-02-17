package by.it.busel.jd02_02;

import java.util.ArrayDeque;

class SoleQueue {
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        queue.addLast(buyer);
    }

    //TODO process NullPointerException
    static synchronized Buyer extract() {
        return queue.pollFirst();
    }

    static synchronized int getBuyersQuantity() {
        return queue.size();
    }

}
