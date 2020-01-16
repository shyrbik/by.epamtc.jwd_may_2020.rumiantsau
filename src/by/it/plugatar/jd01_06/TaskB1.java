package by.it.plugatar.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Вывести в консоль все слова текста,
// начинающихся согласной и заканчивающихся гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            if(search(matcher.group())) System.out.println(matcher.group());
        }
    }

    private static boolean check(char ch){
        char [] chars= {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'};
        for (int i = 0; i < chars.length; i++) {
            if (ch == chars[i]){
                return true;}
        }
        return false;
    }
    
    private static boolean search(String str) {
        char first=str.charAt(0);
        char last=str.charAt(str.length()-1);
        return (check(last) & check(first) == false);
    }

}