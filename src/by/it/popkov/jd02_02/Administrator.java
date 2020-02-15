package by.it.popkov.jd02_02;

/**
 * class Administrator control number of opened Cashier.
 * Notify extra Cashier, when queueSize / onlineCashier > 5
 **/
class Administrator extends Thread {
    @Override
    public void run() {
        while (!Dispatcher.marketIsClosed()) {
            Helper.delay(500);
            int queueSize = BuyerQueue.buyerQueue.size();
            int onlineCashier = Cashier.onlineCashier;
            if (onlineCashier == 0) {
                if (queueSize > 0) {
                    synchronized (Cashier.monitor) {
                        Cashier.monitor.notify();
                    }
                }
            } else if (queueSize / onlineCashier > 5) {
                synchronized (Cashier.monitor) {
                    Cashier.monitor.notify();
                }
            }
        }
        synchronized (Cashier.monitor) {//after market closet restart work and let go home all Cashier
            Cashier.monitor.notifyAll();
        }
    }
}
