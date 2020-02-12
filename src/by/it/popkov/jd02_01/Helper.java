package by.it.popkov.jd02_01;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Helper {

    static final Map<String, Integer> goodsMap = new HashMap<>();
    static void writeGoodsMap(){
        goodsMap.put("bread", 1);
        goodsMap.put("milk", 2);
        goodsMap.put("meat", 3);
        goodsMap.put("cake", 2);
        goodsMap.put("water", 1);
        goodsMap.put("eggs", 2);
        goodsMap.put("apples", 1);
    }

    private static Random random = new Random(System.nanoTime());

    public static int randNum(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
    public static int randNumUntil(int max) {
        return randNum(0, max);
    }
}
