package by.it.popkov.jd02_02;

class Dispatcher {


    static final int SPEED_BOOST = 100;

    static final int PLAN = 100;
    static int buyerOnline = 0;
    static int dayBuyerNum = 0;


    public synchronized static boolean planIsNotCompleted() {
        return dayBuyerNum < PLAN;
    }

    public synchronized static boolean marketIsClosed() {
        return dayBuyerNum == PLAN && buyerOnline == 0;
    }

    public synchronized static void buyerComeIn() {
        buyerOnline++;
        dayBuyerNum++;
    }

    public synchronized static void buyerWentOut() {
        buyerOnline--;
    }
}
