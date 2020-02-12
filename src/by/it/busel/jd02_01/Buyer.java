package by.it.busel.jd02_01;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {

    static int totalBuyerNumber = 0;

    private boolean isPensioner;

    private int cognitiveDelay = 0;

    private Backet personalBacket = new Backet();

    Buyer(int id) {
        if (id % 4 != 0) this.setName("Buyer №" + id);
        else {
            this.setName("Buyer №" + id + " (a retiree) ");
            isPensioner = true;
        }
        cognitiveDelay = isPensioner ?  10 : 15;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int numberOfGoodsNeeded = Helper.getRandomIntValue(1, 4);
        for (int i = 0; i < numberOfGoodsNeeded; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the store.");
    }

    @Override
    public void chooseGoods() {
        Helper.sleep(Helper.getRandomIntValue(500, 2000)*cognitiveDelay/10);
        Map.Entry<String, Double> itemInHands = personalBacket.chooseAnItemOfGoods();
        System.out.println(this + " has chosen an item of goods \"" + itemInHands.getKey() + "\", which costs "
                + itemInHands.getValue() + " BYN.");
    }

    @Override
    public void goOut() {
        System.out.println(this + " has made for the shop-exit and has gone out.");
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.getRandomIntValue(500, 2000));
        System.out.println(this + " has taken a backet.");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.getRandomIntValue(500, 2000));
        Map.Entry<String, Double> lastInputtedItem = personalBacket.putChosenItem();
        System.out.println(this + " has put a chosen item of goods \"" + lastInputtedItem.getKey() + "\", which costs "
                + lastInputtedItem.getValue() + " BYN, to the backet.");

    }
}
