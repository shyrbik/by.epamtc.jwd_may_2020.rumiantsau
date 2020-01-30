package by.it.borodachev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Map<String, Integer> field = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Integer key = 0;
        String word = scanner.next();
        while (!word.equals("end")) {
            field.put(word, key++);
            word = scanner.next();
        }
        Map<Integer, String> ret = new HashMap<>();
        for (Map.Entry<String, Integer> fieldSet : field.entrySet()) {
            // Будем оставлять только первое вхождение . без проверки остается только последнее
             if (!ret.containsKey(fieldSet.getValue())) {
                 ret.put(fieldSet.getValue(), fieldSet.getKey());
             }
        }
        for (Map.Entry<Integer, String> retSet : ret.entrySet()) {
            System.out.println(retSet.getValue() + "=" + retSet.getKey());
        }
    }
}
