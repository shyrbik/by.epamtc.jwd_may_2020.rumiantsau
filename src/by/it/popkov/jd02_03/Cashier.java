package by.it.popkov.jd02_03;

import java.io.PrintStream;
import java.util.Map;

class Cashier implements Runnable {
    private final Object monitorCashier;

    private String name;

    private BuyerQueue buyerQueue;
    private Dispatcher dispatcher;

    public Cashier(int num, BuyerQueue buyerQueue, Object monitorCashier, Dispatcher dispatcher) {
        name = "Cashier " + num;
        this.buyerQueue = buyerQueue;
        this.monitorCashier = monitorCashier;
        this.dispatcher = dispatcher;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (!dispatcher.marketIsClosed()) {
            Buyer pensioner = buyerQueue.getFirstPensioner();
            if (pensioner != null) {
                serve(pensioner);
            } else {
                Buyer buyer = buyerQueue.getFirstBuyer();
                if (buyer != null) {
                    serve(buyer);
                } else {
                    synchronized (monitorCashier) {
                        try {
                            dispatcher.cashierClosed();
                            System.out.println(this + " is closed");
                            monitorCashier.wait();
                            dispatcher.cashierOpened();
                            System.out.println(this + " is opened");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        System.out.println(this + " sent day report and went to home");
    }

    private void serve(Buyer buyer) {
        String pos = "";
        String posBuyerOnline = "";
        System.out.println(this + " start serve " + buyer);
        Helper.delay(Helper.randNum(2000, 5000)); //Time to serve
        String s = buyer.getBasket().toString()
                .replaceAll("[,{}]", "")
                .replaceAll(" ", "\n");
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(this + " print " + buyer + " check");
        switch (this.name) {
            case "Cashier 1":
                pos = "%40s";
                posBuyerOnline = "%160s";
                break;
            case "Cashier 2":
                pos = "%60s";
                posBuyerOnline = "%140s";
                break;
            case "Cashier 3":
                pos = "%80s";
                posBuyerOnline = "%120s";
                break;
            case "Cashier 4":
                pos = "%100s";
                posBuyerOnline = "%100s";
                break;
            case "Cashier 5":
                pos = "%160s";
                posBuyerOnline = "%40s";
                break;
        }
        stringBuffer.append(String.format(pos + posBuyerOnline + "\n", buyer + " check:",
               "Buyer queue size:" + buyerQueue.getBuyerQueueSize()));
        for (Map.Entry<String, Integer> entry : buyer.getBasket().entrySet()) {
            stringBuffer.append(String.format(pos + "\n", entry.getKey() + " = " + entry.getValue()));
        }
        stringBuffer.append(String.format(pos + "\n", " SUM: " + buyer.getBasket().values().stream()
                .mapToInt(Integer::intValue).sum()));
        System.out.println(stringBuffer);
//        System.out.println(stringBuffer.toString());
        System.out.println(this + " finished serve " + buyer);
        synchronized (buyer) {
            buyer.notify();
        }
    }
}
