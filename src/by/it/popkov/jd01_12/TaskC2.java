package by.it.popkov.jd01_12;

import java.util.*;

public class TaskC2 {
    private static Set getCross(Set<? extends Number>... many) {
        Set<Number> outPut = new HashSet<>(many[0]);
        for (Set<? extends Number> numbers : many) {
            outPut.retainAll(numbers);
        }
        return outPut;
    }

    private static Set getUnion(Set<? extends Number>... many) {
        Set<Number> outPut = new HashSet<>(many[0]);
        for (Set<? extends Number> numbers : many) {
            outPut.addAll(numbers);
        }
        return outPut;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(23, 6, 1, 6, 2, 21, 7, 8, 24, 2));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 56, 14, 63, 2, 21, 75, 8, 24, 2));
        Set<Integer> c = new HashSet<>(Arrays.asList(23, 6, 1, 65, 2, 21, 7, 85, 2434, 2));
        System.out.println(getCross(a, b, c));
        System.out.println(getUnion(a, b, c));

    }
}
