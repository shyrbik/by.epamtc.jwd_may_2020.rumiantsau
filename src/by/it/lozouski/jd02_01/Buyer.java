package by.it.lozouski.jd02_01;

import java.util.*;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private Map<String, Integer> backetWithBoughtGoods = new HashMap<>();
    private int timeChoosing = Help.randomGenerateTime(500, 2000);



    public Buyer(int idBuyer) {
        super("ID покупателя: " + idBuyer + " ");
        Dispetcher.buyerCounter++;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Вошел в магазин.");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "Взял корзинку для покупок.");
        try {
            sleep(timeChoosing/Dispetcher.SPEED_K);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Начал выбирать товары.");
        try {
            sleep(timeChoosing/Dispetcher.SPEED_K);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBacket() {
        try {
            sleep(timeChoosing/Dispetcher.SPEED_K);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int setOfGoods = Help.randomGenerateTime(1, 4);
        Object[] keysArray = GoodsInThisMarket.productsForTheBuyer.keySet().toArray();

        for (int product = 1; product <= setOfGoods; product++) {
            int randomIndex = new Random().nextInt(keysArray.length);
            Integer value = GoodsInThisMarket.productsForTheBuyer.get(keysArray[randomIndex].toString());
            backetWithBoughtGoods.put((String) keysArray[randomIndex], value);
            System.out.println(this + "Выбрал товар: " + keysArray[randomIndex] + " Цена: "+ value+"p.");
        }
        System.out.println(this + "Закончил выбирать товары.");

    }

    @Override
    public void goToOut() {
        System.out.println(this + "Вышел из магазина.");
        Dispetcher.buyerCounter--;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
