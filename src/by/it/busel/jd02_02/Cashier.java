package by.it.busel.jd02_02;

class Cashier extends Thread {

    Cashier(int id) {
        this.setName("Cashier №" + id + " ");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        System.out.println(this + " has started to work.");
        while (!Dispatcher.shopCanBeClosed()) {
            //todo method that makes sleep

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
                //TODO check if acceptable
                yield();
            }
        }
        System.out.println(this + " has ended to work.");
    }
}
