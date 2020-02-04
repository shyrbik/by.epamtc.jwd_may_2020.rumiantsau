package by.it.rumiantcau.jd01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestB2deleteLater {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
       /* String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = input.readLine();
        }*/
        String[] names = new String[]{"n1", "n2", "n3"};
        ArrayList<String> peopleAS = new ArrayList<>(Arrays.asList(names));
        LinkedList<String> peopleLS = new LinkedList<>(Arrays.asList(names));

        System.out.println(process(peopleAS));
        System.out.println(process(peopleLS));
    }

    static String process(ArrayList<String> peoples){
        int i = 1;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1){
            while(iterator.hasNext()){
                iterator.next();
                if ((i % 2) == 0) {
                    iterator.remove();
                    i = 1;
                }
                i++;
            }
        }
        return String.valueOf(peoples.get(0));
    }



    static String process(LinkedList<String> peoples){
        int i = 1;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1){
            while(iterator.hasNext()){
                iterator.next();
                if ((i % 2) == 0) {
                    iterator.remove();
                    i = 1;
                }
                i++;
            }
        }
        return String.valueOf(peoples.get(0));
    }

}
