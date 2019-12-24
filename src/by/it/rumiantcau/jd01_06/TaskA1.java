package by.it.rumiantcau.jd01_06;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder poemA1 = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            poemA1.setCharAt(start+3, '#');
            if (matcher.group().length()>=7){ poemA1.setCharAt(start+6, '#');
            }
                     }

        System.out.println(poemA1);
    }
}
