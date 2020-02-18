package by.it.borodachev.jd02_02;

class Buyer extends Thread implements IBuyer{
    private Double sumCheck= Double.valueOf(-1);
    public Buyer(int number) {
        super("Buyer №"+number+" ");
        Dispatcher.buyerIN();
    }

    @Override
    public void add2Queue()  {
        synchronized (Dispatcher.sunc) {
            Dispatcher.buyer2Cash.add(this);
        }
        System.out.println(this+"wait cashier");
        try {
            this.wait();
        }
        catch (InterruptedException e) {
        }
    }
    @Override
    public void pay() {
         sumCheck=Double.valueOf(0);;
     }

    @Override
    public int compare(IBuyer o1, IBuyer o2) {
        return 0;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        add2Queue();
        pay();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"started choosing by goods");
        int timeout= Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+"finshed choosing by goods");

    }

    @Override
    public void goOut() {
        System.out.println(this+"go from the market");
        Dispatcher.buyerOUT();
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
