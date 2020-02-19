package by.it.rumiantcau.jd02_01;

import java.util.ArrayList;
import java.util.Arrays;

public class Good {
    static final ArrayList<String> goodsTest = new ArrayList<>(Arrays.asList("хлеб за 100", "молоко за 200", "сало за 300", "яблоки за 400"));
    static int timeout= Helper.random(500,2000);
    static String putGoodToBacket(){
            String s = Good.goodsTest.get(Helper.random(0, 3));
            System.out.print("положил в корзину товар " + s + "\n");
            Helper.sleep(timeout);
            return s;
    }



}
