package by.it.popkov.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        ListA<String> listA = new ListA<>();
        arrList.add("Ksenia");
        arrList.add("Lena");
        arrList.add("Tania");
        arrList.add("Masha");
        arrList.add("Ania");
        arrList.remove(1);
        System.out.println(arrList);
        listA.add("Ksenia");
        listA.add("Lena");
        listA.add("Tania");
        arrList.add("Masha");
        arrList.add("Ania");
        arrList.remove(1);
        System.out.println(listA);

    }
}
