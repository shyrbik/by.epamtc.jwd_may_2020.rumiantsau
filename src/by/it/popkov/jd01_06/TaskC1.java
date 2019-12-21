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
            Pattern p = Pattern.compile(" +");
            StringBuilder sbRow = new StringBuilder(rows[i]);
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
            int[] pos = new int[0];
            Matcher m = p.matcher(rows[i]);
            while (m.find()) {
                pos = Arrays.copyOf(pos, pos.length + 1);
                pos[pos.length - 1] = m.start();
            }
            while (sbRow.length() != max) {

                for (int i1 = pos.length - 1; i1 >= 0; i1--) {
                    if (sbRow.length() == max) break;
                    sbRow.insert(pos[i1], " ");
                }
                Matcher m2 = p.matcher(sbRow);
                int newPos = 0;
                while (m2.find()){
                    pos[newPos] = m2.start();
                    newPos++;
                }
            }
            rows[i] = sbRow.toString();
//            for (int j = 1; rows[i].length() < max; j++) {
//                rows[i] = rows[i].replaceFirst(" ", "  ");
//            }
        }
        for (String row : rows) {
            newText.append(row).append("\n");
        }
        return newText.toString();
    }
}

