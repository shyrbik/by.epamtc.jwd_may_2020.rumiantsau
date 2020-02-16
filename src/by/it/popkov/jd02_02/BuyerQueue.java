package by.it.popkov.jd02_02;

import java.util.ArrayDeque;

class BuyerQueue {
    private static volatile ArrayDeque<Buyer> buyerQueue = new ArrayDeque<>(96);

    private static volatile ArrayDeque<Buyer> pensionerQueue = new ArrayDeque<>(48);

    public synchronized static void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public synchronized static Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }

    public synchronized static void addToPensionerQueue(Buyer buyer) {
        pensionerQueue.addLast(buyer);
    }

    public synchronized static Buyer getFirstPensioner() {
        return pensionerQueue.pollFirst();
    }

    public synchronized static int getBuyerQueueSize() {
        return buyerQueue.size();
    }

    public synchronized static int getPensionerQueueSize() {
        return pensionerQueue.size();
    }
}
