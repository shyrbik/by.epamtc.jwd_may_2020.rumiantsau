package by.it.shpakovskiy.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] strArray = Poem.text.split("\n");
        StringBuilder[] mutableArray = new StringBuilder[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            mutableArray[i] = new StringBuilder(strArray[i]);
        }
        int maxlen = 0;
        for (String string : strArray) {
            if (string.length() > maxlen) maxlen = string.length();
        }
        for (StringBuilder builder : mutableArray) {
            int count;
            while (builder.length() < maxlen) {
                count = 0;
                while (count < builder.length()) {
                    if (builder.charAt(count) == ' ' && builder.charAt(count + 1) != ' ') {
                        builder.insert(count, " ");
                        count += 2;
                    } else ++count;
                    if (builder.length() == maxlen) break;
                }
            }
        }
        for (int i = 0; i < mutableArray.length-1; i++) {
            mutableArray[i].append("\n");
        }
        for (StringBuilder stringBuilder : mutableArray) {
            System.out.print(stringBuilder);
        }
    }
}
