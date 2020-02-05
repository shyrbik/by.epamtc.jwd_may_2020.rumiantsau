package by.it.borodachev.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Helper.getPath("TaskB.txt", TaskB.class);
        File inStream = new File(fileName);
        int marks;
        int words;
        try (Scanner scanner = new Scanner(inStream)) {
            scanner.useDelimiter("[^a-zA-zа-яёА-ЯЁ \\r\\n]{1,}");
            String strSome;
            marks = 0;
            words = 0;
            while ((strSome = scanner.next()) != null) {
                marks++;
                String[] wordArr = strSome.trim().split(" ");
                words += wordArr.length;
            }
        }

        printConsoleAndFile(Helper.getPath(
                    "ResultTaskB.txt", TaskB.class),
                    "words=" + words + ",punctuation marks=" + marks);
          }
    private static void printConsoleAndFile(String fileName,String resultTxt) {
        System.out.println(resultTxt);
        try (PrintWriter writer = new PrintWriter(fileName)){
           writer.println(resultTxt);

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
