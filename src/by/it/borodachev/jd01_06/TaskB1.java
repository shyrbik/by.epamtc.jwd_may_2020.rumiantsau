package by.it.borodachev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pat= Pattern.compile("[а-яёА-ЯЁ]{2,}");
        String txt=new String(Poem.text);
        Matcher m=pat.matcher(txt);
        while (m.find()) {
            isNeedWord(m.group());
        }
    }
    private static void isNeedWord(String word) {
        String soglChars="цкнгшщзхфвпрлджчсмтб";
        String glChars="уеыаоэяиюё";
        if (word.length() >0 )
        { if ((glChars.indexOf(word.toLowerCase().charAt(word.length()-1))>=0)
            &&
            (soglChars.indexOf(word.toLowerCase().charAt(0))>=0))
            System.out.println(word);
        }
    }
}
