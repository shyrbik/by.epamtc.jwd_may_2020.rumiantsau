package by.it.plugatar.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//В каждом слове текста 4-ю и 7-ю буквы заменить символом #.
// Для слов короче 4 символов корректировку не выполнять. Для слов короче 7 символов заменять только 4-ю букву.

public class TaskA1 {
    public static void main(String[] args) {
        Pattern p= Pattern.compile("[а-яА-яёЁ]{4,}");
        //Pattern sb= Pattern.compile("[а-яА-яёЁ]+");//1 более раз
        StringBuilder varText = new StringBuilder(Poem.text);
        Matcher matcher = p.matcher(varText) ;//  p.Matcher(varText)
        while (matcher.find()){
            int start=matcher.start();
            varText.setCharAt(start+3, '#');//4-ую
            if (matcher.end() - start>=7)
                varText.setCharAt(start+6, '#');//7-ую

        }
        System.out.println(varText);
    }
}
