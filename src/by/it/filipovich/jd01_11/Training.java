package by.it.filipovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Training {
    public static void main(String[] args) {
    String[] str = new String[]{"abc","def","ghi","jkl"};
        List<String> line = new ArrayList<>();

        for (String s : str) {
            line.add(s);
        }
        String s = line.get(2);
        System.out.println(line);
        System.out.println(s);

    }

}
