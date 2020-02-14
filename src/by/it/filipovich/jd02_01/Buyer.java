package by.it.filipovich.jd02_01;


class Buyer extends Thread implements IBuyer{

    public Buyer(int number){
        super("Buyer № "+number+" entered");
        Dispatcher.count++;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the Market");
        Dispatcher.count++;
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose the goods");
        Helper.sleep(Helper.random(500, 2000));
        System.out.println(this + " finished to choose the goods");
    }


    @Override
    public void goOut() {
        System.out.println(this + " went out from Market");
        Dispatcher.count--;
    }
}
