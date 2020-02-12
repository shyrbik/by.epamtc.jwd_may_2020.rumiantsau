package by.it.busel.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Backet {
    private static Map<String, Double> goodsNomenclature = new HashMap<>();

    static {
        goodsNomenclature.put("Bread", 0.99);
        goodsNomenclature.put("Vegetables", 3.74);
        goodsNomenclature.put("Milk", 1.59);
        goodsNomenclature.put("Poultry", 12.69);
    }

    private Map<String, Double> personalGoods = new HashMap<>();

    private int numberOfItemNextToBeAddedToPersonalGoods = 1;

    private Map.Entry<String, Double> lastChosenItem;

    Map.Entry<String, Double> chooseAnItemOfGoods() {
        int counter = 1;
        for (Map.Entry<String, Double> item : goodsNomenclature.entrySet()) {
            if (counter++ == numberOfItemNextToBeAddedToPersonalGoods) {
                lastChosenItem = item;
                numberOfItemNextToBeAddedToPersonalGoods++;
                break;
            }
        }
        return lastChosenItem;
    }

    Map.Entry<String, Double> putChosenItem() {
        personalGoods.put(lastChosenItem.getKey(), lastChosenItem.getValue());
        return lastChosenItem;
    }
}
