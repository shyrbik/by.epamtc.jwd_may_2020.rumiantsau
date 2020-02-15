package by.it.popkov.jd02_02;

class Cashier implements Runnable {
    static final Object monitor = new Object();

    static volatile int onlineCashier = 5; //Work in start of day 5

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
                System.out.println(this + " print " + buyer + " check: " + buyer.getBasket() + " SUM: "
                        + buyer.getBasket().values().stream().mapToInt(Integer::intValue).sum());
                System.out.println(this + " finished serve " + buyer);
                synchronized (buyer) { //Finished serve, buyer can continue
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        onlineCashier--;
                        System.out.println(this + " is closed");
                        monitor.wait();
                        onlineCashier++;
                        System.out.println(this + " is opened");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(this + " send day report");
    }
}
