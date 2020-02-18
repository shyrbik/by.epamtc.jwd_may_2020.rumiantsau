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
                try {
                    waitTillNotified();
                } catch (InterruptedException e) {
                    System.out.println(this + " has left the shop!!!.");
                    return;
                }
            }
            Buyer buyerAtTheCounter = SoleQueue.extract();
            serve(buyerAtTheCounter);
        }
        Dispatcher.cashierClosesTheCounter();
        System.out.println(this + " has ended to work.");
        System.out.println(this + " has left the shop.");
    }

    private void waitTillNotified() throws InterruptedException {
        synchronized (this) {
            Dispatcher.cashierClosesTheCounter();
            System.out.println(this + " has ended to work!!!.");
            wait();
            Dispatcher.cashierOpensTheCounter();
            System.out.println(this + " has started to work!!!.");
        }
    }

    @SuppressWarnings("all")
    private void serve(Buyer buyerAtTheCounter) {
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
}
