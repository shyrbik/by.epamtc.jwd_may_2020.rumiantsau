package by.it.filipovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> array = new ArrayList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");

        array.add("One");
        array.add("Two");
        array.add("Three");
        array.add("Four");
        array.add("Five");

        myList.remove(1);

        System.out.println(myList);
    }
}
