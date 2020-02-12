package by.it.shpakovskiy.jd02_01;

import java.util.*;

class BulbaStore {
    private Map<String, Integer> goods;
    private Set<Buyer> buyers;
    private Set<Basket> baskets;
    private int k = 0;

    public BulbaStore() {
        goods = new HashMap<>();
        buyers = new HashSet<>();
        baskets = new HashSet<>();
        goods.put("meat", 150);
        goods.put("lard", 100);
        goods.put("sausage", 76);
        goods.put("mayonnaise", 22);
        goods.put("bread", 11);
        goods.put("milk", 37);
        goods.put("potatoes", 50);
        goods.put("draniki", 85);
        goods.put("fried potatoes", 52);
        goods.put("bananas", 35);
        goods.put("apples", 35);
        goods.put("persimmons", 35);
        for (int i = 0; i < 30; i++) {
            baskets.add(new Basket());
            k++;
        }
    }

    public synchronized Basket getBasket() {
        k--;
        return baskets.iterator().next();
    }

    public synchronized boolean isBasketsEmpty() {
        return k > 0;
    }

    public synchronized void returnBasket() {
        k++;
    }

    public String getSomeGoods() {
        int num = Helper.getRandom(0, goods.size() - 1);
        Iterator<String> it = goods.keySet().iterator();
        for (int i = 0; i < num; i++) {
            it.next();
        }
        return it.next();
    }

    public synchronized int enter(Buyer buyer) {
        buyers.add(buyer);
        return buyers.size();
    }

    public synchronized int leave(Buyer buyer) {
        buyers.remove(buyer);
        return buyers.size();
    }

    public synchronized int buyersCount() {
        return buyers.size();
    }
}
