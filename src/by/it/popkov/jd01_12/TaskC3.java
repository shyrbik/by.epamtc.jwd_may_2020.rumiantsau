package by.it.popkov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC3 {


    static boolean check(String row) {
        Deque<String> deque = new LinkedList<>();
        Pattern p = Pattern.compile("[\\[\\](){}]");
        Matcher m = p.matcher(row);
        while (m.find()) {
            deque.add(m.group());
        }
        while (deque.size() > 0) { // Удаляем правильные пары пока не будет 0 size
            switch (deque.getFirst()) {
                case "{":
                    if (deque.getLast().equals("}")) { // Если две крайние соответсвуют {[()]}
                        deque.removeFirst();
                        deque.removeLast();
                    } else { //Если две крайние не правильны, проверяем идёт ли за первой сразу закрывающая её {}([])
                        deque.removeFirst();
                        if (deque.getFirst().equals("}")) deque.removeFirst();
                        else return false;
                    }

                    break;
                case "[":
                    if (deque.getLast().equals("]")) {
                        deque.removeFirst();
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                        if (deque.getFirst().equals("]")) deque.removeFirst();
                        else return false;
                    }
                    break;
                case "(":
                    if (deque.getLast().equals(")")) {
                        deque.removeFirst();
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                        if (deque.getFirst().equals(")")) deque.removeFirst();
                        else return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        check(row);



//        Map<String, Integer> map = new HashMap<>();
//        map.put("(", 0);
//        map.put(")", 0);
//        map.put("{", 0);
//        map.put("}", 0);
//        map.put("[", 0);
//        map.put("]", 0);
//        Scanner scanner = new Scanner(System.in);
//        String row = scanner.nextLine();
//        Pattern p = Pattern.compile("[\\[\\](){}]");
//        Matcher m = p.matcher(row);
//        while (m.find()) {
//            map.put(m.group(), map.get(m.group()) + 1);
//        }
//        if (map.get(")").equals(map.get("(")) && map.get("[").equals(map.get("]")) && map.get("{").equals(map.get("}")))
//            System.out.println("true");
//        else System.out.println("false");


    }
//    private static boolean check(String row) { //Будем ходить итераторам пока не удалим все пары или false
//        List<String> linkedList = new ArrayList<>();
//        Pattern p = Pattern.compile("[\\[\\](){}]");
//        Matcher m = p.matcher(row);
//        while (m.find()) {
//            linkedList.add(m.group());
//        }
//        for (int i = 0; i < linkedList.size(); ) {
//            String first = linkedList.get(i);
//            if (first.equals("}") || first.equals(")") || first.equals("]")) return false; //Стразу нет
//            for (String second : linkedList) {
//
//                if (first.equals("{") && second.equals("}")) {
//                    linkedList.remove(i);
//                    linkedList.remove(second);
//                    i--;
//                    break;
//                } else if (first.equals("(") && second.equals(")")) {
//                    linkedList.remove(i);
//                    linkedList.remove(second);
//                    i--;
//                    break;
//                } else if (first.equals("[") && second.equals("]")) {
//                    linkedList.remove(i);
//                    linkedList.remove(second);
//                    i--;
//                    break;
//                }
//            }
//            i++;
//        }
//        return linkedList.size() <= 0;
//    }
}
