package by.it.plugatar.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number){
        super("Buyer №:"+number);
    }

    @Override
    public void run() {
        super.run();
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"Buyer enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"Started choosing goods");
        RandomHelper.sleep(500,2000);
        System.out.println(this+"Finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+"Go out from the market");
    }
    /*
    @Override
    String ToString()

     */
}
