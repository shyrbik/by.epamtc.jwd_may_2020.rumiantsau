package by.it.tarasevich.jd01_06;

import java.util.Arrays;

public class TaskB1 {
    public static void main(String[] args) {
        String sb = new String(Poem.text);
        sb = sb.trim();
        String[] res = sb.split(" ");
        String[] sogl = {"Ц", "ц", "Й", "й", "К", "к", "Н", "н", "Г", "г", "Ш", "ш", "Щ", "щ", "З", "з", "Х", "х", "Ф", "ф", "В", "в", "П", "п",
                "Р", "р", "Л", "л", "Д", "д", "Ж", "ж", "Ч", "ч", "С", "с", "М", "м", "Т", "т", "Б", "б"};
        String[] gl = {"А", "а", "Я", "я", "О", "о", "Ё", "ё", "Э", "э", "Е", "е", "У", "у", "Ю", "ю", "И", "и", "Ы", "ы"};
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < sogl.length; j++) {
                for (int k = 0; k < gl.length; k++) {
                    if (res[i].substring(0, 1).equals(sogl[j]) && res[i].substring(res[i].length() - 1).equals(gl[k])) {
                        System.out.println(res[i]);
                    }
                }
            }
        }
    }
}