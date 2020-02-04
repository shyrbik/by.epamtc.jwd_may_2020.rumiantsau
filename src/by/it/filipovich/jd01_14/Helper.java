package by.it.filipovich.jd01_14;

import java.io.*;

class Helper {
    static void insertNumbers(File newFile) {
        try {
            FileOutputStream fis = new FileOutputStream(newFile);
            BufferedOutputStream bis = new BufferedOutputStream(fis);
            DataOutputStream dos = new DataOutputStream(bis);
            for (int i = 0; i < 20; i++) {
                int number = (int) Math.random() * 100;
                dos.write(number);
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
