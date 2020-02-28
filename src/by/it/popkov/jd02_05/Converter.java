package by.it.popkov.jd02_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


class Converter {
    public static void main(String[] args) {
        try {
            List<String> stringList = Files.lines(
                    Paths.get("D:/Prog/IdeaProjects/JD2019-12-04/src/by/it/popkov/jd02_05/txt/hello.txt"))
                    .collect(Collectors.toList());
            System.out.println(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
