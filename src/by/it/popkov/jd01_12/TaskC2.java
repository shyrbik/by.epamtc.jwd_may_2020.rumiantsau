package by.it.popkov.jd01_12;

import java.util.*;
//?????????????????Добавить привидение к отдному типу, как если бы 2.0, 2L, 2 были бы одним и тем же
class TaskC2 {
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
        Set<Double> d = new HashSet<>(Arrays.asList(23.0, 6.0, 1.0, 6.0, 2.0, 21.0, 7.0, 8.0, 24.0, 2.0));
        Set<Long> l = new HashSet<>(Arrays.asList(1L, 2L, 3L, 24L, 34L, 23L, 999L, 4L, 34L, 1234L, 5L, 2L, 14L, 777L, 5L));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 56, 14, 63, 2, 21, 75, 8, 24, 2));
        Set<Integer> c = new HashSet<>(Arrays.asList(23, 6, 1, 65, 2, 21, 7, 85, 2434, 2));
        System.out.println(getCross(d, l, b, c));
        System.out.println(getUnion(d, l, b, c));

    }
}
