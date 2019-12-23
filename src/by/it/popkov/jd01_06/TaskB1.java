package by.it.popkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[А-Яа-яЁё]{2,}");
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()){
            if (check(m1.group())){
                System.out.println(m1.group());
            }
        }
    }

    private static boolean check(String word) {
        char[] chWord = word.toLowerCase().toCharArray();
        switch (chWord[0]){
            case 'а':
            case 'о':
            case 'я':
            case 'е':
            case 'и':
            case 'ю':
            case 'ё':
            case 'э':
            case 'ы':
            case 'у':
            case 'ъ':
            case 'ь':
                return false;
        }
        switch (chWord[chWord.length-1]){
            case 'а':
            case 'о':
            case 'я':
            case 'е':
            case 'и':
            case 'ю':
            case 'ё':
            case 'э':
            case 'ы':
            case 'у':
                return true;

        }
        return false;
    }
}
