package by.it.lozouski.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("------------------МАГАЗИН ОТКРЫЛСЯ.-------------------");
        GoodsInThisMarket.productListInThisMarket();//заполнил магазин товарами
        List<Buyer> buyersInMarket = new ArrayList<>();
        int buyerId = 0;
        for (int openTime = 0; openTime <= 120; openTime++) {
            int count = Help.randomGenerateTime(0, 2);
            for (int i = 1; i <= count; i++) {
                Buyer currentBuyer = new Buyer(++buyerId);
                buyersInMarket.add(currentBuyer);
                currentBuyer.start();
            }
            Help.sleep(1000);
        }

        for (Buyer thisBuyer : buyersInMarket) {
            try {
                thisBuyer.join();
            } catch (InterruptedException e) {
                System.out.println("TEST ERROR2!");
            }
        }
        System.out.println("------------------МАГАЗИН ЗАКРЫЛСЯ.-------------------");
    }
}
