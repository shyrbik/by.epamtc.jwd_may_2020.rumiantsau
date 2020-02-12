package by.it.kuzmichalex.jd2_01;

import java.util.HashMap;

public class Goods {
    static private HashMap<String,Integer> mapOfGoods = new HashMap<>();
    public Goods() {
        mapOfGoods.put("Bread",123);
        mapOfGoods.put("Butter",215);
        mapOfGoods.put("Sugar",222);
        mapOfGoods.put("Juice",321);
        mapOfGoods.put("Fish",10);
        mapOfGoods.put("Meat",218);
        mapOfGoods.put("Potato",225);
        mapOfGoods.put("Tomato",218);
        mapOfGoods.put("Pineapple",348);
        mapOfGoods.put("Sausage",128);
        mapOfGoods.put("Toast",233);
        mapOfGoods.put("Blackberry",235);
        mapOfGoods.put("Apple",133);
        mapOfGoods.put("Mushroom",325);
        mapOfGoods.put("Milk",210);
        mapOfGoods.put("Chocolate",228);
        mapOfGoods.put("Tortilla",428);
        mapOfGoods.put("Honey",211);
        mapOfGoods.put("Tea",153);
        mapOfGoods.put("some expensive sh..t",12228);
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
