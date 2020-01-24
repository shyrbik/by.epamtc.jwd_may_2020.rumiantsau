package by.it.popkov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        List<String> listA = new ListA<>();
        List<String> listB = new ListB<>();
        arrList.add("Ksenia");
        arrList.add("Lena");
        arrList.add("Tania");
        arrList.add("Masha");
        arrList.add("Ania");
        arrList.add("Ania2");
        arrList.add(2,"ADD");
        System.out.println(arrList);
        listB.add("Ksenia");
        listB.add("Lena");
        listB.add("Tania");
        listB.add("Masha");
        listB.add("Ania");
        listB.add("Ania2");
        listB.add(2,"ADD");
        System.out.println(listB);

    }
}
