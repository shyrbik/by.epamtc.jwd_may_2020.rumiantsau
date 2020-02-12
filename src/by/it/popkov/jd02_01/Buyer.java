package by.it.popkov.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private Map<String, Integer> basket = new HashMap<>();

    public Buyer(int name) {
        super("Buyer " + name);
    }

    @Override
    public void takeBacket() {
        try {
            sleep(Helper.randNum(500, 2000) / Dispatcher.SPEED_BOOST);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " take basket");
    }

    @Override
    public void putGoodsToBacket() {
        try {
            sleep(Helper.randNum(500, 2000) / Dispatcher.SPEED_BOOST);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int goods = 1; goods <= Helper.randNum(1, 4); goods++) {
            int iteratorCounter = 1;
            int selectedGood = Helper.randNum(1, 7);
            for (Map.Entry<String, Integer> entry : Helper.goodsMap.entrySet()) {
                if (iteratorCounter == selectedGood) {
                    basket.put(entry.getKey(), entry.getValue());
                    System.out.println(this + " puts " + entry.getKey() + " with cost " + entry.getValue());
                }
                iteratorCounter++;
            }
        }

    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
            sleep(Helper.randNum(500, 2000) / Dispatcher.SPEED_BOOST);
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
