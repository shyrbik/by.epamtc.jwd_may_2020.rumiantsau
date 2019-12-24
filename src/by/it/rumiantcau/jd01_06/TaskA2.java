package by.it.rumiantcau.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
       private static String[] stroki = new String[0];
       private static int[] stolbcy = new int[0];

    private static int pos(String word){
        for (int i = 0; i < stroki.length; i++) {
            if (stroki[i].equals(word)) {return i;}

        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();

            int p = pos(word);
            if (p>=0){stolbcy[p]++;}
            else {
                int last = stroki.length;
                stroki = Arrays.copyOf(stroki, last+1);
                stroki[last] = word;
                stolbcy = Arrays.copyOf(stolbcy, last+1);
                stolbcy[last] = 1;


            }

            for (int i = 0; i < stroki.length; i++) {
                System.out.println(stroki[i] +"="+stolbcy[i]);

            }
        }

    }




}
