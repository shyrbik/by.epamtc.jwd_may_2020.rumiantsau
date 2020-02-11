package by.it.samuseva.jd02_01;

class Buyer extends Thread implements IBuyer{
    Buyer(int number) {
        super("Buyer №" + " " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Helper.sleep(1000);
        System.out.println(this.getName() + " " + "entered the market.");
    }

    @Override
    public void chooseGoods() {
        int terminat =-500+ (int) (Math.random()*2000);
        Helper.sleep(terminat);
        System.out.println(this.getName() + " " + "chose the goods.");
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " " + "left the market.");
    }

    @Override
    public String toString() {
        return  this.toString();
    }
}
