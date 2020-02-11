package by.it.popkov.jd02_01;

class Buyer extends Thread implements IBuyer {


    public Buyer(int name) {
        super("Buyer " + name);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return super.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " came in to our shop");
    }

    @Override
    public void chooseGoods() {
        try {
            sleep(MyRandom.randNum(500, 2000) / Dispatcher.SPEED_BOOST);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " picked goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " went out from our shop");
    }
}
