package by.it.lozouski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яЁё]{2,}+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            if (test(word)){
                System.out.println(word);
            }
        }
    }

    private static boolean test(String word){
        word = word.toLowerCase();
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        boolean check = false;
        switch (first){
            case 'б': case 'в': case 'г': case 'д': case 'ж':case 'з':case 'й':case 'к':
                case 'л':case 'м':case 'н':case 'п':case 'р':case 'с':case 'т':case 'ф':
                    case 'х':case 'ц':case 'ш':case 'ч':case 'щ': check = true;
        }
        if (check){
            switch (last){
                case 'а':case 'у':case 'о':case 'ы':case 'и':
                    case 'э':case 'я':case 'ю':case 'ё':case 'е': return true;
            }
        }
        return false;
    }
}
