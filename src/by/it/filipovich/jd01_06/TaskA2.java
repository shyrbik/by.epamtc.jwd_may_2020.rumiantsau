package by.it.filipovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = {};
    private static int[] count = {};

    private static int position(String word){
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()){
            String word = matcher.group();
            int pos = position(word);
            if(pos >= 0) {
                count[pos]++;
            }
            else{
                int lastElem = words.length;
                words = Arrays.copyOf(words, lastElem + 1);
                words[lastElem] = word;
                count = Arrays.copyOf(count, lastElem+1);
                count[lastElem] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+ count[i]);
        }

    }
}
