package by.it.filipovich.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        File newFile = new File("dataTaskA.bin");
        File newFile2 = new File("resultTaskA.txt");
        int sum = 0;
        double avg = 0;
        Helper.insertNumbers(newFile);

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(newFile)));
            while (dis.available()>0){
                int i = dis.readInt();
                sum = sum+i;
                list.add(i);
                System.out.print(i+" ");
            }
            avg = (double) sum/list.size();
            System.out.println("avg="+avg);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
