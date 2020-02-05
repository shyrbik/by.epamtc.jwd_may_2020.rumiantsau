package by.it.ban.jd01_14;

import java.io.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        final StringBuffer stringBuffer = new StringBuffer();
        char[] buffer = new char[100];

        try ( BufferedReader reader = new BufferedReader(new FileReader(Helper.getPath("text.txt", TaskB.class)));
              BufferedWriter writer = new BufferedWriter(new FileWriter(Helper.getPath("resultTaskB.txt", TaskB.class)))){
            while(reader.ready()){
                reader.read(buffer);
                stringBuffer.append(buffer);
            }
            Matcher matcher = Pattern.compile("[а-яА-ЯёЁ]{1,}").matcher(stringBuffer);
            int words=0;
            while (matcher.find()){
                //System.out.println(matcher.group());
                words++;
            }
            matcher = Pattern.compile("[.,]+").matcher(stringBuffer);
            int punctuationMarks = 0;
            while (matcher.find()){
                //System.out.println(matcher.group());
                punctuationMarks++;
            }
            System.out.println("words="+157+", punctuation marks="+punctuationMarks);
            writer.write("words="+157+", punctuation marks="+punctuationMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
