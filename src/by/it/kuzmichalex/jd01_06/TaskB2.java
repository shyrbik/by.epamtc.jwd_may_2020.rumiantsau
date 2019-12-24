package by.it.kuzmichalex.jd01_06;

/***
 * @author kuzmichalex
 * Задание B2. Вывести через \n предолжения поэмы в порядке возрастания количества символов.
 */
public class TaskB2 {
    public static void main(String[] args) {
        //Мне так не нравится! Но, говорят, есть короткое решение. Пожалуйста!
        String inputBuffer = new String(Poem.text.replace("\n", " ").replace("!",".").replace(" - "," ").
                replace("...","").replace(",","").replace(":","").trim());
        String[] arrSentences=inputBuffer.split("[\\\\.][ ]");
        //Наверняка есть способ отсортировать это при помощи Arrays.sort и comparator.... аа, ладно.
        int[] arrLength=new int[arrSentences.length];
        int minLength=Integer.MAX_VALUE;
        int maxLength=Integer.MIN_VALUE;
        for (int i = 0; i < arrSentences.length; i++) {
            arrLength[i]=arrSentences[i].length();
            if(arrLength[i]>maxLength)maxLength=arrLength[i];
            if(arrLength[i]<minLength)minLength=arrLength[i];
        }
        for (int currentLeng = minLength; currentLeng <=maxLength ; currentLeng++) {
            for (int i = 0; i <arrSentences.length ; i++) {
                if(arrLength[i]==currentLeng) System.out.println(arrSentences[i]);
            }
        }
    }
}
