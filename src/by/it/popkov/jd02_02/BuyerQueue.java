package by.it.popkov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class BuyerQueue {
    static ArrayDeque<Buyer> buyerQueue = new ArrayDeque<>();

    public synchronized static void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public synchronized static Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }
}
