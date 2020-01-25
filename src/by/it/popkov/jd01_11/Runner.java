package by.it.popkov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<Short> objects = new HashSet<>();
        Set<Short> mySet = new SetC<>();
        ListB<Short> listB = new ListB<>();
//        objects.add("Ksenia");
//        objects.add("Ksenia");
//        objects.add("Lena");
//        objects.add("Tania");
//        objects.add("Tania");
//        objects.add("Masha");
//        objects.add("Ania");
        for (int i = 0; i < 10; i++) {
            objects.add((short) (i * 2));
            listB.add((short) (i * 2));
        }
//
//        System.out.println(objects);
//
//
////        mySet.add("Ksenia");
////        mySet.add("Ksenia");
////        mySet.add("Lena");
////        mySet.add("Tania");
////        mySet.add("Tania");
////        mySet.add("Masha");
////        mySet.add("Ania");
        System.out.println(listB);
    }
}
