package by.it.samuseva.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String fileName = Helper.getDirectory("dataTaskA.bin", TaskA.class);
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int) (Math.random()*100));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)));
             PrintWriter pw = new PrintWriter(
                     new FileWriter(Helper.getDirectory("resultTaskA.txt", TaskA.class)))
        )
        {
            double sum = 0;
            List<Integer> list = new ArrayList<Integer>();
            while (input.available()>0){
                list.add(input.readInt());
            }
            for (Integer element : list) {
                System.out.print(element + " ");
                pw.print(element);
                sum +=element;
            }
            System.out.println("\nagv="+ sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
