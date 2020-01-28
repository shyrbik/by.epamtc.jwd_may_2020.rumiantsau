package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskB2 {
    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Fedya", "Kolya", "Volodya", "Manya", "Valya", "Matroskin", "Kesha", "Vasya", "Sharik", "Galya");
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }
}
