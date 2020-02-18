package by.it.popkov.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BuyerQueue {
    private final BlockingDeque<Buyer> buyerQueue = new LinkedBlockingDeque<>(30);

    private final ConcurrentLinkedDeque<Buyer> pensionerQueue = new ConcurrentLinkedDeque<>();

    public synchronized void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public synchronized Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }

    public synchronized void addToPensionerQueue(Buyer buyer) {
        pensionerQueue.addLast(buyer);
    }

    public synchronized Buyer getFirstPensioner() {
        return pensionerQueue.pollFirst();
    }

    public synchronized int getBuyerQueueSize() {
        return buyerQueue.size();
    }

    public synchronized int getPensionerQueueSize() {
        return pensionerQueue.size();
    }
}
