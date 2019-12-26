package by.it.borodachev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        String txt=new String(Poem.text);
        Pattern pat= Pattern.compile("[а-яёА-ЯЁ]{4,}");
        Matcher m=pat.matcher(txt);
        while (m.find()) {
            if ((m.group().length() >=4) & (m.group().length() <7))
            {String reptxt=m.group();
                reptxt=reptxt.substring(0,3)+"#"+reptxt.substring(4);
                txt=txt.replaceAll(m.group(),reptxt);
            }
            else if(m.group().length() >=7)
            {String reptxt=m.group();
                reptxt=reptxt.substring(0,3)+"#"+reptxt.substring(4,6)+"#";
                if (m.group().length() >7)
                {reptxt+=m.group().substring(7);};
                txt=txt.replaceAll(m.group(),reptxt);
            }
        }
        System.out.printf("%s",txt);

    }
}
