package by.it.popkov.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class TaskB {
    //1
    //2
    int t; /*
    * 3
    *
    * */ int a;
    /*
     * 4
     *
     * */ int b;
    /**
     *
     * 5
     *
     * **/   int c;

    public static void main(String[] args) {
        System.out.println(read(Support.fileFullName(TaskB.class, "TaskB.java")).toString());

    }

    private static StringBuilder read(String fileFullName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object[] objects = Files.lines(Paths.get(fileFullName))
                    .map(o -> o.replace("//", "\n//"))
                    .map(o -> o.replace("/*", "\n/*"))
                    .map(o -> o.replace("*/", "*/\n"))
                    .map(o -> o.replace("/**", "\n/**"))
                    .map(o -> o.replace("**/", "**/\n")).toArray();
            boolean open = false;
            boolean close = false;
            for (Object object : objects) {
                String line = (String) object;
                if (line.contains("//"))continue;
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}
