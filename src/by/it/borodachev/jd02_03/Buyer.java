package by.it.borodachev.jd02_03;

import static java.lang.Thread.State.WAITING;

class Buyer extends Thread implements IBuyer {
    public Buyer(int number) {
        super("Buyer №"+number+" ");
        Dispatcher.buyerEnter();
    }

    @Override
    public void add2Queue()  {
        System.out.println(this+" Ожидание очереди");
        try { Dispatcher.buyer2Cash.put(this);}
              catch (InterruptedException e) {
                  System.out.println(" Error:"+this+e.toString());
              }
        System.out.println(this+" Стоит в очереди");
          // если кто-то спит разбудим
            for (Cashier cashier : Dispatcher.cashiers) {
                if (cashier.getState()==WAITING) {
                    System.out.println(cashier+" будим");
                    synchronized (cashier) {
                        cashier.notify();
                    }
                }
            }
       synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {  System.out.println(" Error:"+this+e.toString());
            }
        }
    }
    @Override
    public void pay(int numCash) {
         return ;
     }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        add2Queue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Вошел в Магазин");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" Выбор товара");
        int timeout= Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+" Товар выбран");

    }

    @Override
    public void goOut() {
        Dispatcher.buyerLeave();
        System.out.println(this+" Вышел из магазина");

    }


    @Override
    public String toString() {
        return this.getName();
    }
}
