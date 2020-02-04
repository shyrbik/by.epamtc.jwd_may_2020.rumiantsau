package by.it.popkov.jd01_14;

import java.io.*;
import java.util.Random;

class TaskA {
    public static void main(String[] args) {
        String f = Support.fileFullName(TaskA.class, "dataTaskA.bin");
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            for (int i = 0; i < 20; i++) {
                Random random = new Random();
                dos.writeInt(random.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Точно в цель, но не в ту");
        }
    }
}