package by.it.borodachev.jd02_02;

public class Cashier extends Thread{
     public Cashier (int numCashier) {super ("Cashier "+numCashier); }
    @Override
    public void run() {
     synchronized (Dispatcher.sunc) {
     if (Dispatcher.buyer2Cash.peek()==null)
     {
         // Ждем следующего
         int timeout= Helper.random(500);
         Helper.sleep(timeout);
     }
     else {
        IBuyer b = Dispatcher.buyer2Cash.poll();
         System.out.println(b+" to cashier");
         // обслуживаем
         int timeout = Helper.random(2000, 5000);
         synchronized (b) {
             Helper.sleep(timeout);
             b.pay();
             b.notify();
         }
       }
      }
    }
}
