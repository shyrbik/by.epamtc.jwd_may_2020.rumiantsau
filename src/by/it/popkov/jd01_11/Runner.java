package by.it.popkov.jd01_11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        List<String> listA = new ListA<>();
        List<String> objects = new ArrayList<>();
        objects.add("KseniaA");
        objects.add("LenaA");
        objects.add("TaniaA");
        objects.add("MashaA");
        objects.add("AniaA");
        objects.add("AniaA");
        objects.add("AniaA");
        objects.add(null);
        List<String> listB = new ListB<>();

        arrList.add("Ksenia");
        arrList.add("Lena");
        arrList.add("Tania");
        arrList.add("Masha");
        arrList.add("Ania");
        arrList.addAll(objects);
        System.out.println(arrList);

        listB.add("Ksenia");
        listB.add("Lena");
        listB.add("Tania");
        listB.add("Masha");
        listB.add("Ania");
        listB.addAll(objects);
        System.out.println(listB);

    }
}
