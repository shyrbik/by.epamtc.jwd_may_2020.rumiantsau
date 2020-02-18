package by.it.filipovich.jd02_02;

public class Dispatcher {
    static final int K_SPEED=1000;
    static final int PLAN=1000;

    private final static Object monitor = new Object();

    private volatile static int enterBuyer=0;
    private volatile static int countBuyer=0;

    static boolean marketIsOpened(){
        synchronized (monitor) { //volatile ???
            return enterBuyer < PLAN;
        }
    }

    static boolean marketIsClosed(){
        synchronized (monitor) {
            return enterBuyer == PLAN && countBuyer==0;
        }
    }

    static void buyerEnter(){
        synchronized (monitor) {
            enterBuyer++;
            countBuyer++;
        }
    }

    static void buyerLeave(){
        synchronized (monitor) {
            countBuyer--;
        }
    }
}
