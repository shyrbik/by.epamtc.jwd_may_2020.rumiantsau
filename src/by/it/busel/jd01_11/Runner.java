package by.it.busel.jd01_11;

public class Runner {
    public static void main(String[] args) {
        ListA<Integer> listA = new ListA<>();
        listA.add(1);
        listA.add(2);
        listA.add(2);
        listA.add(2);
        listA.add(2);
        System.out.println(listA);

        ListB<Integer> listB = new ListB<>();
        listB.add(1);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        System.out.println(listB);
//
//        String[] elements = new String[6];
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = "Привет";
//        }
//        elements[5] = null;
//        for (String element : elements) {
//            System.out.println(element);
//        }
        listB.add(0, null);
        System.out.println(listB);


    }
}
