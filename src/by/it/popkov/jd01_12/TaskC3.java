package by.it.popkov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//????? Идёт проверка только на соответствие количетства окрывающих скобок к закрывающим. Нужно ли проверять что то ещё?
class TaskC3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 0);
        map.put(")", 0);
        map.put("{", 0);
        map.put("}", 0);
        map.put("[", 0);
        map.put("]", 0);
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        Pattern p = Pattern.compile("[\\[\\](){}]");
        Matcher m = p.matcher(row);
        while (m.find()) {
            map.put(m.group(), map.get(m.group()) + 1);
        }
        if (map.get(")").equals(map.get("(")) && map.get("[").equals(map.get("]")) && map.get("{").equals(map.get("}")))
            System.out.println("true");
        else System.out.println("false");


    }
}
