package by.it.popkov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaskA {
    public static void main(String[] args) {
        String f = Support.fileFullName(TaskA.class, "dataTaskA.bin");
        writeFile(f);
        List<Integer> integerList = fileToList(f);
        printList(integerList);
        printAvg(integerList);
    }

    private static void printAvg(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum = sum + integer;
        }
        System.out.println("avg=" + sum / integerList.size());
    }

    static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    static List<Integer> fileToList(String f) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            int i = 0;
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            System.out.println("dataInputStream Error");
        }
        return list;
    }

    static void writeFile(String f) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            for (int i = 0; i < 20; i++) {
                Random random = new Random();
                dos.writeInt(random.nextInt());
            }
        } catch (IOException e) {
            System.out.println("dos Error");
        }
    }
}