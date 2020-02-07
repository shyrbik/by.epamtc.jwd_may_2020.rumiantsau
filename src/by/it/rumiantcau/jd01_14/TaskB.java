package by.it.rumiantcau.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
* Вариант B. В классе TaskB нужно выполнить следующие шаги:
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 Вариант C. В классе TaskC нужно выполнить следующие шаги:
 Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt
* */
public class TaskB {
    public static void main(String[] args) {
        //считываем текст из файла построчно в стрингбилдер
        StringBuilder str = readTextFile(Helper.getPath("TaskB.txt", TaskA.class));
        //подсчитываем количество знаков пунктуации
        int punctuationCount = patternMatcher(str , "[.?!,;:()]");
        //подсчитываем количество слов
        int wordsCount = patternMatcher(str, "[А-Яа-яёЁA-Za-z]{1,}");
        String result = "words=" + wordsCount + ", punctuation marks=" + punctuationCount;
        System.out.println(result);
        //записываем результат в файл
        writeTextFile(Helper.getPath("resultTaskB.txt", TaskA.class), result);
    }

    private static int patternMatcher(StringBuilder str, String s) {
        int wordsCount = 0;
        Matcher words = Pattern.compile(s).matcher(str);
        while (words.find()) {
            wordsCount++;
        }
        return wordsCount;
    }

    private static StringBuilder readTextFile(String fileNameB) {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileNameB), StandardCharsets.UTF_8))){
            while ((line = reader.readLine()) != null) {
                str.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("It is a trap!");
        }
        return str;
    }

    private static void writeTextFile(String fileNameB, String result) {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileNameB), StandardCharsets.UTF_8))){
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
