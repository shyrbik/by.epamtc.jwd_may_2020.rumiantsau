package by.it.shpakovskiy.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class TaskB {
    /**
     * Main input text this program without comments
     */
    public static void main(String[] args) {
        String fileName = "src/by/it/shpakovskiy/jd01_15/TaskB.java";
        try {
            StringBuilder stringBuilder = readFileWithDeleteCements(fileName);
            String resultFileName = "src/by/it/shpakovskiy/jd01_15/TaskB.txt";
//            Files.writeString(Paths.get(resultFileName), stringBuilder);
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Defines interfaces and classes for the Java virtual machine to access files, file attributes, and file systems.
    /*
    Path    An object that may be used to locate a file in a file system.
    Files	This class consists exclusively of static methods that operate on files, directories, or other types of files.
    Paths	This class consists exclusively of static methods that return a Path by converting a path string or URI.
     */
    /* FileSystemException thrown when a file system operation fails on one or two files. */

    /**
     * @param fileName is file name
     * @return stringBuilder
     * @throws IOException It's good exception
     */
    private static StringBuilder readFileWithDeleteCements(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Files.lines(Paths.get(fileName)).forEach(line -> stringBuilder.append(line).append("\n"));
        StringBuilder resultBuilder = new StringBuilder();
        boolean isSingleLineComment = false;
        boolean isMultiLineComment = false;
        if (stringBuilder.length() > 0) {
            char first = stringBuilder.charAt(0);
            for (int i = 0; i < stringBuilder.length(); i++) {
                char second = stringBuilder.charAt(i);
                if (isSingleLineComment) {
                    if (second == '\n') {
                        isSingleLineComment = false;
                        resultBuilder.append(second);
                    }
                } else if (isMultiLineComment) {
                    if (first == '*' && second == '/') {
                        isMultiLineComment = false;
                    }
                } else {
                    if (first == '/' && second == '*') {
                        isMultiLineComment = true;
                        resultBuilder.deleteCharAt(resultBuilder.length() - 1);
                    } else if (first == '/' && second == '/') {
                        isSingleLineComment = true;
                        resultBuilder.deleteCharAt(resultBuilder.length() - 1);
                    } else resultBuilder.append(second);
                }
                first = second;
            }
        }
        return resultBuilder;
    }
}
