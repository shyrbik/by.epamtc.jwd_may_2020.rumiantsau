package by.it.ban.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

class Buyer extends Thread implements IBuyer, IUseBacket {
    boolean pensioner;
    double speed;
    List<Entry<String,Double>> backet;

    public Buyer(int number) {
        super("Покупатель N"+number+" ");
        Dispatcher.countBuyer++;
    }

    public Buyer(int number, boolean pensioner) {
        super("Покупатель N"+number+" ");
        this.pensioner=pensioner;
        if(pensioner)
            this.speed=1.5;
        else
            this.speed=1.0;
//        System.out.println("pens="+this.pensioner+" speed="+this.speed);
        Dispatcher.countBuyer++;
    }

    @Override
    public void run() {
        enterTheMarket();
        takeBacket();
        for (int i = 1; i <=Helper.random(4) ; i++) {
            putGoodsToBacket();
        }
        chooseGoods();
        exitTheMarket();
    }

    @Override
    public void enterTheMarket() {
        if (this.pensioner)
            System.out.println(this+"вошел в магазин (Пенсионер)");
        else
            System.out.println(this+"вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"приступил к выбору товара");
        Helper.sleep((int) (Helper.random(500,2000)*this.speed));
        System.out.println(this+"окончил выбор товара");
    }

    @Override
    public void exitTheMarket() {
        System.out.println(this+"вышел из магазина");
        Dispatcher.countBuyer--;
    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        this.backet=new ArrayList();
        System.out.println(this+"взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep((int) (Helper.random(500,2000)*this.speed));
       /* int goodRandom=Helper.random(1,4);
        List<Entry> goods = new ArrayList<>(Good.goods.entrySet().toArray());

        for (int i = 0; i < Good.goods.entrySet().size() && i<goodRandom; i++) {
            this.backet.add(([Helper.random(1,4)]);
        }*/
        System.out.println(this+"положил выбранный товар в корзину");
    }
}
