package by.it.busel.jd02_02;

class Cashier extends Thread {

    Cashier(int id) {
        this.setName("Cashier №" + id + " ");
        Dispatcher.cashierOpensTheCounter();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        System.out.println(this + " has started to work.");
        while (!Dispatcher.shopCanBeClosed()) {
            if (Dispatcher.saysCashierToCloseTheCounter()) {
                if (Dispatcher.shopDoorsAreStillOpened()) {
                    synchronized (this) {
                        try {
                            Dispatcher.cashierClosesTheCounter();
                            System.out.println(this + " has ended to work!!!.");
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Dispatcher.cashierOpensTheCounter();
                            System.out.println(this + " has started to work!!!.");
                        }
                    }
                } else {
                    break;
                }
            }
            Buyer buyerAtTheCounter = SoleQueue.extract();
            if (buyerAtTheCounter != null) {
                System.out.println(this + " has started to serve " + buyerAtTheCounter);
                Helper.sleep(2000, 5000);
                buyerAtTheCounter.payOff();
                System.out.println(this + " has ended to serve " + buyerAtTheCounter);
                synchronized (buyerAtTheCounter) {
                    buyerAtTheCounter.notify();
                }
            } else {
                yield();
            }
        }
        Dispatcher.cashierClosesTheCounter();
        System.out.println(this + " has ended to work.");
    }
}
