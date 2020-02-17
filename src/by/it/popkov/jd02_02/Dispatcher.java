package by.it.popkov.jd02_02;

class Dispatcher {


    final static int SPEED_BOOST = 100;
    final int cashierMax = 5;
    final int plan = 100;

    private int buyerOnline = 0;
    private int dayBuyerNum = 0;


    private final Object onlineCashierMonitor = new Object();
    private int onlineCashier = cashierMax;

    public synchronized boolean planIsNotCompleted() {
        return dayBuyerNum < plan;
    }

    public synchronized boolean marketIsClosed() {
        return dayBuyerNum == plan && buyerOnline == 0;
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
