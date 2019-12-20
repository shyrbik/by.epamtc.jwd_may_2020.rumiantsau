package by.it.popkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern split = Pattern.compile("[/.]+");
        Pattern n = Pattern.compile("[-,!:\\n]");
//        Pattern sp = Pattern.compile(" {2,}");
        StringBuilder sbText = new StringBuilder(Poem.text);
        Matcher m = n.matcher(sbText);
        while (m.find()) {
            sbText.replace(m.start(), m.end(), " ");
        }

//        Matcher space = sp.matcher(sbText);
//        while (space.find()){
//            sbText.replace(space.start(), space.end(), "   ");
//        }

        String[] textArray = split.split(sbText);
        for (int i = 0; i < textArray.length; i++) {
            String s = textArray[i];
            s = s.trim().replaceAll("\\s{2,}", " ");
            System.out.println(s);


        }

    }
}
