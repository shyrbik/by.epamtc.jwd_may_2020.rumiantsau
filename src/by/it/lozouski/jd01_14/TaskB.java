package by.it.lozouski.jd01_14;

import java.io.*;
import java.util.Scanner;

class TaskB {
    static String patternForWords = "[a-zA-Zа-яА-яЁё]+";
    static String patternForPunctuationMarks = "[,.!?:;-]+";

    public static void main(String[] args) {
        String fileName = Helper.getPath("text.txt", TaskB.class);
        String resultTaskBtxt = fileText(fileName);
        System.out.println(resultTaskBtxt);

        String taskFileName = Helper.getPath("resultTaskB.txt",TaskB.class);
        writeToFile(resultTaskBtxt,taskFileName);

    }

    static String fileText(String fileName) {
        File myFile = new File(fileName);
        int countWords = 0;
        int countPunctuationMarks = 0;
        try (Scanner sc1 = new Scanner(myFile)) {
            while (sc1.hasNext()) {
                String word = sc1.next();
                if (word.matches(patternForWords)) {
                    countWords++;
                } else if (word.matches(patternForWords + patternForPunctuationMarks)) {
                    countPunctuationMarks++;
                    countWords++;
                } else if (word.matches(patternForPunctuationMarks)) {
                    countPunctuationMarks++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ВСЁ ПОЛОМАЛОСЬ!!!");
            e.printStackTrace();
        }
        return "words=" + countWords + " punctuation marks=" + countPunctuationMarks;
    }

    static void writeToFile(String resultTaskString, String taskFileName) {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(taskFileName))) {
            bufferedWriter.write(resultTaskString);
        } catch (IOException e) {
            System.out.println("ВСЁ ПОЛОМАЛОСЬ!!!");
            e.printStackTrace();
        }
    }
}
