package by.it.popkov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> objects = new HashSet<>();
        Set<String> mySet = new SetC<>();
        objects.add("Ksenia");
        objects.add("Ksenia");
        objects.add("Lena");
        objects.add("Tania");
        objects.add("Tania");
        objects.add("Masha");
        objects.add("Ania");


        System.out.println(objects);


        mySet.add("Ksenia");
        mySet.add("Ksenia");
        mySet.add("Lena");
        mySet.add("Tania");
        mySet.add("Tania");
        mySet.add("Masha");
        mySet.add("Ania");
        mySet.remove("Masha");
        System.out.println(mySet);
    }
}
