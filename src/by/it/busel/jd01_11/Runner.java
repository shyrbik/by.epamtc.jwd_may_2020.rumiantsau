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
    }
}
