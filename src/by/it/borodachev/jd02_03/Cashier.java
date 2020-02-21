package by.it.borodachev.jd02_03;

import java.util.concurrent.TimeUnit;

public class Cashier extends Thread{
    private int numCash;
    public Cashier (int numCashier) {

        super ("Cashier "+numCashier);
        numCash=numCashier;
    }
    @Override
    public void run() {
        IBuyer b=null;
        while (!Dispatcher.marketClosed()) {
             try {
                 b = Dispatcher.buyer2Cash.poll(100, TimeUnit.MILLISECONDS);
             } catch (InterruptedException e) {}
           if (b == null) {
                 synchronized (this) {
                    try {
                        Dispatcher.countCashier.decrementAndGet();
                        System.out.println(this+" спит");
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                     Dispatcher.countCashier.incrementAndGet();
                     System.out.println(this+" работает");
                }
            }
             else {
                System.out.println(b + " в кассе");
                // обслуживаем
                int timeout = Helper.random(2000, 5000);
                synchronized (b) {
                    Helper.sleep(timeout);
                    b.pay(numCash);
                    System.out.println(b + " расплатился");
                    b.notify();
                    System.out.println(b + " Пнули на улицу");
                }
            }
    }
    }
}
