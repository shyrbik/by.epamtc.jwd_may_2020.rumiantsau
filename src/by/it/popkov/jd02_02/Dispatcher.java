package by.it.popkov.jd02_02;

class Dispatcher {


    static final int SPEED_BOOST = 300;

    static final int PLAN = 100;
    static int buyerOnline = 0;
    static int dayBuyerNum = 0;


    public synchronized static boolean marketIsOpen() {
        return true; ////TO DO
    }
}
