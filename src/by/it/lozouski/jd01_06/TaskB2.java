package by.it.lozouski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String sbr = Poem.text;
        String[] sss = sbr.replaceAll("[\\n]|(\\.){2,}", " ").split("\\.+");
        for (int i = 0; i < sss.length; i++) {
            sss[i] = sss[i].replaceAll("[^ЁёА-Яа-я\\s]", "").replaceAll("\\s+",  " ").trim();
        }
        bubbleStringSort(sss);
        for (String elem : sss) {
            System.out.println(elem);
        }
    }

    static void bubbleStringSort(String[] mas) {
        boolean isSorted = false;
        String buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i].length() > mas[i + 1].length()) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
    }
}
