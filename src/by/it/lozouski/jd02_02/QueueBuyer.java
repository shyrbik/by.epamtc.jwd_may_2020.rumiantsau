package by.it.lozouski.jd02_02;

import java.util.ArrayDeque;

class QueueBuyer {
    private static ArrayDeque<Buyer> buyersQueue = new ArrayDeque<>();

    static synchronized void addBuyerToQueue(Buyer currBuyer) {
        buyersQueue.add(currBuyer);
    }

    static synchronized Buyer extractBuyerFromQueue() {
        return buyersQueue.pollFirst();
    }
}
