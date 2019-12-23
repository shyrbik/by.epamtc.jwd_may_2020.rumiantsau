package by.it.potapovich.jd01_06;

public class TaskB1 {
    //  private static String [] w = {Poem.text};
    // private static String pos(String word){
    //   for (int i = 0; i < w.length; i++) {
    //        if (w[i]=)

    //  }
    //  }

    public static void main(String[] args) {
        String text = Poem.text;
        text = text.trim();
        text = text.replaceAll("\\p{Punct}", "");
        // String vowel ="a", "е","ё","и","о","й","у","э","ы","я","ю" ;
        char[] vowel = {'а', 'е', 'ё', 'и', 'о',  'у', 'э', 'ы', 'я', 'ю','А', 'Е', 'Ё', 'И', 'О',  'У', 'Э', 'Ы', 'Я', 'Ю'};
        char[] consonant = {'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф', 'в', 'п', 'р', 'л', 'д', 'ж', 'ч', 'с', 'м', 'т', 'б','Ц', 'К', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ф', 'В', 'П', 'Р', 'Л', 'Д', 'Ж', 'Ч', 'С', 'М', 'Т', 'Б', };
        for (int j = 0; j < vowel.length; j++) {
            for (int k = 0; k < consonant.length; k++) {
                char vowels = vowel[j];
                char consonants = consonant[k];


                String[] line = text.split("\n");
                for (String s : line) {
                    String[] words = s.split(" ");

                    // int length = word.length;
                    for (int i = 0; i < words.length; i++) {
                        String word = words[i];
                        boolean isWordInvalid = word.trim().isEmpty() || word.length() == 1;
                        if (isWordInvalid) {
                            continue;
                        }
                        char indexStart = word.charAt(0);
                        char indexEnd = word.charAt(word.length() - 1);

                        if (indexStart == consonants && indexEnd == vowels) {
                            System.out.println(word);
                        }


                    }


                }
            }
        }
    }
}








