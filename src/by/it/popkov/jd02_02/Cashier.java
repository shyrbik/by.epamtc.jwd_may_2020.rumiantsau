package by.it.popkov.jd02_02;

class Cashier implements Runnable {
    private String name;

    public Cashier(int num) {
        name = "Cashier " + num;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyerQueue.getFirstBuyer(); //Берём баера их очереди
            if (buyer != null) {
                System.out.println(this + " start serve " + buyer);
                Helper.delay(Helper.randNum(2, 5)); //Time to serve
                synchronized (buyer) { //Finished serve, buyer can continue
                    buyer.notify();
                }
                System.out.println(this + " finished serve " + buyer);
            }
            else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
