package by.it.plugatar.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {
    static Map<String, Double> priceList = new HashMap<>();

    static void loadPriceList() {
        priceList.put("батон", 0.7);
        priceList.put("кефир", 1.3);
        priceList.put("яйца", 1.4);
        priceList.put("сыр", 4.0);
        priceList.put("свинина", 3.1);
        priceList.put("сосиски", 2.1);
        priceList.put("помидоры", 3.4);
        priceList.put("огурцы", 0.6);
        priceList.put("паштет", 2.2);
        priceList.put("чай", 3.1);
        priceList.put("масло", 2.2);
    }
    //геттер размера списка товаров магазина
    int getPriceListSize() {
        return priceList.size();
    }

    //геттер цены товара из списка товаров магазина
    double getPrice(String goods) {
        if (priceList.containsKey(goods)){
            return (int) Math.round(priceList.get(goods)*10)/10.0;
        } else
            return 0.0;
    }
}
