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
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = BuyerQueue.getFirstBuyer(); //Берём баера их очереди
            if (buyer != null) {
                System.out.println(this + " start serve " + buyer);
                Helper.delay(Helper.randNum(2000, 5000)); //Time to serve
                System.out.println(this + " finished serve " + buyer);
                synchronized (buyer) { //Finished serve, buyer can continue
                    buyer.notify();
                }
            }
            else {
                Helper.delay(1);
            }
        }
        System.out.println(this + " finish work");
    }
}
