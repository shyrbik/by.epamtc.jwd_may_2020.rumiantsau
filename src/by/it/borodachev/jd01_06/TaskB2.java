package by.it.borodachev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String txt = Poem.text.replaceAll("\\.\n", "|");
        txt = txt.replaceAll("\n", " ");

          String [] longWords=txt.split("\\|");
        for (int i = 0; i < longWords.length; i++) {
            longWords[i]=longWords[i].replaceAll("[^а-яёА-ЯЁ]+"," ").trim();
        }
          mergeSort(longWords);
        for (String longWord : longWords) {
            System.out.println(longWord);
        }
        }

    static void mergeSort(String[] mas) {
        mergeSort(mas, 0, mas.length - 1);
    }

    static void mergeSort(String[] mas, int left, int right) {
        if (mas.length == 0) return;
        if (left >= right) return;
        String median = mas[(left + (right - left) / 2)];
        int i = left, j = right;
        while (i <= j) {
            while (mas[i].length() < median.length()) {
                i++;
            }
            while (mas[j].length() > median.length()) {
                j--;
            }
            if (i <= j) {
                String tmp = mas[i];
                mas[i] = mas[j];
                mas[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) mergeSort(mas, left, j);
        if (right > i) mergeSort(mas, i, right);
    }
}
