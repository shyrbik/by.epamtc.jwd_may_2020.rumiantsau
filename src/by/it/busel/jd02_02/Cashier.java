package by.it.busel.jd02_02;

import java.util.Map;

class Cashier extends Thread {

    private static Double totalRevenue = 0.0;

    private static final Object totalRevenueMonitor = new Object();

    private static void increaseTotalRevenue(Double value) {
        synchronized (totalRevenueMonitor) {
            totalRevenue = totalRevenue + value;
        }
    }

    static Double getTotalRevenue() {
        synchronized (totalRevenueMonitor) {
            return totalRevenue;
        }
    }


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
            Map<String, Double> personalGoods = buyerAtTheCounter.payOff();

            System.out.println(getCheck(buyerAtTheCounter, personalGoods));

            System.out.println(this + " has ended to serve " + buyerAtTheCounter);
            synchronized (buyerAtTheCounter) {
                buyerAtTheCounter.notify();
            }
        } else {
            yield();
        }
    }

    private String getCheck(Buyer buyerAtTheCounter, Map<String, Double> personalGoods) {
        int index = 0;
        Double total = 0.0;
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Data output from a cashier (check) ").append("for ").append(buyerAtTheCounter).append('\n');
        sb.append("╔══════════════╦══════════════════════╦══╦════════════╦══════╦═════════════╦═════════════╗")
                .append('\n');
        sb.append("║").append("Cashier's name").append("║").append("Buyer's name          ").append("║").append("№№").
                append("║").append("item        ").append("║").append("price ").append("║")
                .append("queue size   ").append("║").append("total revenue").append("║").append("\n");
        for (Map.Entry<String, Double> entry : personalGoods.entrySet()) {
            total = total + entry.getValue();
            increaseTotalRevenue(entry.getValue());
            sb.append("╠══════════════╬══════════════════════╬══╬════════════╬══════╬═════════════╬═════════════╣")
                    .append('\n');
            sb.append("║").append(String.format("%14s", this))
                    .append("║").append(String.format("%22s", buyerAtTheCounter))
                    .append("║").append(String.format("%2d", ++index))
                    .append("║").append(String.format("%12s", entry.getKey()))
                    .append("║").append(String.format("%6.2f", entry.getValue()))
                    .append("║").append(String.format("%13d", SoleQueue.getBuyersQuantity()))
                    .append("║").append(String.format("%13.2f", getTotalRevenue())).
                    append("║").append('\n');
        }
        sb.append("╚══════════════╩══════════════════════╩══╩════════════╩══════╩═════════════╩═════════════╝").
                append('\n');
        sb.append("╔══════════════╦══════════════════════╗\n");
        sb.append(String.format("║%14s║%-5.2f %-16s║%n", "To pay:", total, "BYN"));
        sb.append("╚══════════════╚══════════════════════╝\n");
        return sb.toString();
    }
}
