package by.it.busel.jd02_01;

class Buyer extends Thread implements IBuyer {
    Buyer(int id) {
        super("Buyer №" + id);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the store.");
    }

    @Override
    public void chooseGoods() {
        try {
            sleep(Helper.getRandomIntValue(500, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " has chosen an item of goods.");
    }

    @Override
    public void goOut() {
        System.out.println(this + " has made for the shop-exit and has gone out.");
    }
}
