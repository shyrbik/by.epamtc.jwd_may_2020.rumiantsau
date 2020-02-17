package by.it.popkov.jd02_02;

class Dispatcher {


    final static int SPEED_BOOST = 100;
    final int CASHIER_MAX = 5;
    final int PLAN = 100;

    private int buyerOnline = 0;
    private int dayBuyerNum = 0;


    private final Object onlineCashierMonitor = new Object();
    private int onlineCashier = CASHIER_MAX;

    public synchronized boolean planIsNotCompleted() {
        return dayBuyerNum < PLAN;
    }

    public synchronized boolean marketIsClosed() {
        return dayBuyerNum == PLAN && buyerOnline == 0;
    }

    public synchronized void buyerComeIn() {
        buyerOnline++;
        dayBuyerNum++;
    }

    public synchronized int getBuyerOnline() {
        return buyerOnline;
    }

    public synchronized void buyerWentOut() {
        buyerOnline--;
    }

    public void cashierClosed() {
        synchronized (onlineCashierMonitor){
            onlineCashier--;
        }
    }

    public void cashierOpened() {
        synchronized (onlineCashierMonitor){
            onlineCashier++;
        }
    }

    public int getOnlineCashier() {
        synchronized (onlineCashierMonitor){
            return  onlineCashier;
        }
    }
}
