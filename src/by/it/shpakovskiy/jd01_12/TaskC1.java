package by.it.shpakovskiy.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Long, String> c1 = new TreeMap<>();
        while (true) {
            String line = scanner.next();
            if (line.equals("end")) {
                break;
            }
            c1.put(System.nanoTime(), line);
        }
        System.out.println(c1);
        Map<String, Long> buf = new HashMap<>();
        for (Map.Entry<Long, String> entry : c1.entrySet()) {
            buf.putIfAbsent(entry.getValue(), entry.getKey());
        }
        c1 = new TreeMap<>();
        for (Map.Entry<String, Long> entry : buf.entrySet()) {
            c1.put(entry.getValue(), entry.getKey());
        }
        System.out.println("________________________________");
        System.out.println(c1);
    }
}
