package by.it.lozouski.jd02_02;

class Cashier implements Runnable {
    private String name;

    public Cashier(int idCashier) {
        name = "КАССИР №" + idCashier + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "ОТКРЫЛСЯ!");
        while (!Dispetcher.marketClosed()) {
            Buyer buyer = QueueBuyer.extractBuyerFromQueue();
            if (buyer != null) {
                System.out.println(this + "НАЧАЛ ОБСЛУЖИВАНИЕ " + buyer);
                Help.sleep(Help.randomGenerate(2000, 5000));
                System.out.println(this + "ЗАКОНЧИЛ ОБСЛУЖИВАНИЕ " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Help.sleep(1);
        }
        System.out.println(this + "ЗАКРЫЛСЯ!");
    }

    @Override
    public String toString() {
        return name;
    }
}
