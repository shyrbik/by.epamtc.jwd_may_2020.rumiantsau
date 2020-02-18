package by.it.busel.jd02_02;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private boolean isPensioner;

    private double cognitiveDelay;

    private Backet personalBacket = new Backet();

    Buyer(int id) {
        if (id % 4 != 0) this.setName("Buyer №" + id);
        else {
            this.setName("Buyer №" + id + " (a retiree)");
            isPensioner = true;
        }
        cognitiveDelay = !isPensioner ? 1 : 1.5;
        Dispatcher.buyerEntered();
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
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the store.");
    }

    @Override
    public void takeBacket() {
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        System.out.println(this + " has taken a backet.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " has started to choose an item of goods.");
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        Map.Entry<String, Double> itemInHands = personalBacket.chooseAnItemOfGoods();
        System.out.println(this + " has chosen an item of goods \"" + itemInHands.getKey() + "\", which costs "
                + itemInHands.getValue() + " BYN.");
    }

    @Override
    public void putGoodsToBacket() {
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        Map.Entry<String, Double> lastInputtedItem = personalBacket.putChosenItem();
        System.out.println(this + " has put a chosen item of goods \"" + lastInputtedItem.getKey() + "\", which costs "
                + lastInputtedItem.getValue() + " BYN, to the backet.");

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " has made for the sole queue in the shop.");
        SoleQueue.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " has made for the shop-exit and has gone out.");
        Dispatcher.buyerLeft();
    }
}
