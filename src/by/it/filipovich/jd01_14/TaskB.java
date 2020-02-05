package by.it.filipovich.jd01_14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        int symbols = getSymbols("text.txt");
        int words = getWords("text.txt");
        System.out.println("words="+words+", punctuation marks="+symbols);
    }

    private static int getWords(String s) {
        int countWord = 0;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            countWord++;
        }
        return countWord;
    }

    private static int getSymbols(String s) {
        int countSymbol = 0;
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            countSymbol++;
        }
        return countSymbol;
    }


}
