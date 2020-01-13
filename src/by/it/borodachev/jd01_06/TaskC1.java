package by.it.borodachev.jd01_06;

public class TaskC1 {
        public static void main(String[] args) {
            int maxlen = 0;
            String[] arrStr = Poem.text.split("\n");
            for (String s : arrStr) {
                if (maxlen < s.length()) {
                    maxlen = s.length();
                }
            }
            for (String s : arrStr) {
                StringBuilder newStr;

                if (s.length() == maxlen) {
                    newStr = new StringBuilder(s);
                } else {
                    String[] words = s.split(" ");
                    int cntWords = words.length;
                    int lenWords = 0;
                    for (String word : words) {
                        lenWords += word.length();
                    }
                    int cntSpaceOther = (maxlen - lenWords) / (cntWords - 1);
                    int cntSpaceFirt = ((maxlen - lenWords) % (cntWords - 1));
                    newStr = new StringBuilder();
                    newStr.append(words[0]);
                    for (int i = 0; i < cntSpaceOther; i++) {
                        newStr.append(' ');
                    }
                    if (cntSpaceFirt >0) {newStr.append(' '); cntSpaceFirt--;}
                    for (int i = 1; i < cntWords - 1; i++) {
                        newStr.append(words[i]);
                        for (int j = 0; j < cntSpaceOther; j++) {
                            newStr.append(' ');
                        }
                        if (cntSpaceFirt >0) {newStr.append(' '); cntSpaceFirt--;}
                    }
                    newStr.append(words[cntWords - 1]);
                }
                    System.out.println(newStr);

            }

        }
        }
