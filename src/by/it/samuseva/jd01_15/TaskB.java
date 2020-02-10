package by.it.samuseva.jd01_15;

import java.io.File;

public class TaskB {
    public static void main(String[] args) {
        String fileRead = Helper.getPath("TaskB.java",TaskB.class);
        System.out.println(fileRead);
    }
}
