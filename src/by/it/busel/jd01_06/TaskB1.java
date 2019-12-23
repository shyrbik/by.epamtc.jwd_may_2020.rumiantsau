package by.it.busel.jd01_06;


public class TaskB1 {
    private static String[] pMarks = {",", ".", "-", ":", "!", "\n"};
    private static String[] vowels = {"и", "а", "у", "о", "ы", "э", "я", "ю", "е", "ё"};

    private static void cleaner(StringBuilder text) {
        for (String pMark : pMarks) {
            if (!pMark.equals("\n")) {
                while (text.indexOf(pMark) >= 0) {
                    text.deleteCharAt(text.indexOf(pMark));
                }

            } else {
                while (text.indexOf(pMark) >= 0) {
                    text.setCharAt(text.indexOf(pMark), ' ');
                }
            }
        }
    }

    private static void printerTaskB1(StringBuilder text) {
        String s = new String(text);
        String[] array = s.split(" ");
        boolean firstLetterIsAVowel;
        boolean lastLetterIsAVowel;
        for (String str : array) {
            if (str.length() >= 2) {
                firstLetterIsAVowel = false;
                lastLetterIsAVowel = false;
                for (String vowel : vowels) {
                    if (String.valueOf(str.charAt(0)).equalsIgnoreCase(vowel)) {
                        firstLetterIsAVowel = true;
                    }
                    if (str.endsWith(vowel)) {
                        lastLetterIsAVowel = true;
                    }
                    if (!(firstLetterIsAVowel) && lastLetterIsAVowel) {
                        System.out.println(str);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        cleaner(text);
        printerTaskB1(text);
    }
}
