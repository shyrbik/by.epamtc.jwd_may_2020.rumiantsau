package by.it.plugatar.jd02_02;

public class Dispatcher {
    private static final Object monitor=new Object();

    static final int K_SPEED=100;

    static final int PLAN=100;

    private static int enterBuyer=0;
    private static int countBuyer=0;

    static boolean marketOpened() {
        synchronized (monitor) {//volatile??
            return enterBuyer < PLAN;
        }
    }

    static boolean marketClosed(){
        synchronized (monitor){
            return enterBuyer== PLAN && countBuyer==0;
        }
    }


    static void buyerEnter(){
        enterBuyer++;
        countBuyer++;
    }
}
