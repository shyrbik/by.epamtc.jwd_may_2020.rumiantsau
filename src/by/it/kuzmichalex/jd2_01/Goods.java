package by.it.kuzmichalex.jd2_01;

import java.util.HashMap;

public class Goods {
    static private HashMap<String,Integer> mapOfGoods = new HashMap<>();
    public Goods() {
        mapOfGoods.put("Bread",123);
        mapOfGoods.put("Butter",211);
        mapOfGoods.put("Sugar",222);
        mapOfGoods.put("Juice",321);
        mapOfGoods.put("Fish",10);
        mapOfGoods.put("Meat",228);
        mapOfGoods.put("Tea",153);
    }

  /*  static int getCount(){
        return mapOfGoods.size();
    }*/

    static String getSomeGood(){
        if(mapOfGoods.size()==0) return "нет продуктов :(";
        Object[] objects = mapOfGoods.keySet().toArray();
        return (String) objects[TimeHelper.getRandom(0,objects.length-1)];
    }


}
