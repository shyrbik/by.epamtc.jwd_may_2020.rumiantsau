package by.it.popkov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        System.out.println(centre(Poem.text));
    }

    private static String centre(String text) {
        StringBuilder newText = new StringBuilder();
        String[] rows = text.split("\\n");
        int max = -1;
        for (String row : rows) {
            if (row.length() > max) {
                max = row.length();
            }
        }
        for (int i = 0; i < rows.length; i++) {
//            Pattern p = Pattern.compile(" ");
//            String[] word = p.split(rows[i]);
//            int counter = 0;
//            for (int j = 0; counter != max; j++) {
//                if (j % (word.length - 1) == 0) {
//                    counter += word[j].length();
//                    if (counter == max) {
//                        break;
//                    } else {
//                        counter = 0;
//                        j = -1;
//                    }
//                }else {
//                    word[j] += " ";
//                    counter += word[j].length();
//                }
//
//
//            }
//            rows[i] = "";
//            for (int i1 = 0; i1 < word.length; i1++) {
//                rows[i] += word[i1];
//            }
//            Matcher m = p.matcher(rows[i]);
//            while (m.find() && rows[i].length() != max) {
//                rows[i] = rows[i].split(p)
//            }
            for (int j = 1; rows[i].length() < max; j++) {
                rows[i] = rows[i].replaceFirst(" ", "  ");
            }
        }
        for (String row : rows) {
            newText.append(row).append("\n");
        }
        return newText.toString();
    }
}

