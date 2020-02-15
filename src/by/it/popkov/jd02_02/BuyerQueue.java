package by.it.popkov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class BuyerQueue {
    static volatile ArrayDeque<Buyer> buyerQueue = new ArrayDeque<>(150);

    public synchronized static void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public synchronized static Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }
}
