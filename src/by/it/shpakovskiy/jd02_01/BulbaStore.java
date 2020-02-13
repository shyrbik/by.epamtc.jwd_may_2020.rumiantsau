package by.it.shpakovskiy.jd02_01;

import java.util.*;

class BulbaStore {
    private final Map<String, Integer> goods;
    private Set<Buyer> buyers;
//    private Set<Basket> baskets;
//    private static final Object myMonitor = new Object();
//    private volatile int k;

    public BulbaStore() {
        goods = new HashMap<>();
        buyers = new HashSet<>();
//        baskets = new HashSet<>();
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
//        for (int i = 0; i < basketsCount; i++) {
//            baskets.add(new Basket());
//        }
//        k = basketsCount;
    }

    //public synchronized Basket getBasket(){
//        Basket basket=baskets.iterator().next();
//        baskets.remove(basket);
//        return basket;
//    }
//    public Basket getBasket() {
//        synchronized (myMonitor) {
//            k--;
//            return baskets.iterator().next();
//        }
//    }

    //public synchronized boolean isBasketsEmpty(){
//        return baskets.isEmpty();
//    }
//    public synchronized boolean isBasketsEmpty() {
//        synchronized (myMonitor) {
//            return k > 0;
//        }
//    }

    //public synchronized void returnBasket(Basket basket){
//        baskets.add(basket);
//    }
//    public void returnBasket() {
//        synchronized (myMonitor) {
//            k++;
//        }
//    }


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
