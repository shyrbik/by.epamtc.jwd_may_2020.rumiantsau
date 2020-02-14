package by.it.popkov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class BuyerQueue {
    static private Deque<Buyer> buyerQueue = new ArrayDeque<>();

    public static void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public static Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }
}
