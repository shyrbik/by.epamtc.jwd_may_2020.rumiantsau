package by.it.akhmelev.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> wordNumber = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String row = scanner.next();
            if (row.equals("end")) break;
            sb.append(row).append(" ");
        }
        String[] split = sb.toString().trim().split("[— /!?:;,.]+");
        for (String s : split) {
            if (!wordNumber.containsKey(s)) {
                wordNumber.put(s, 1);
            } else {
                wordNumber.put(s, wordNumber.get(s) + 1);
            }
        }
        System.out.println(wordNumber);
    }
}
