package by.it.kuzmichaa.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern word_pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher word_matcher = word_pattern.matcher(Poem.text);

    }

    private static String [] w = {};
}
