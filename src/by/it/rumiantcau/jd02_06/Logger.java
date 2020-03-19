package by.it.rumiantcau.jd02_06;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private int exceptionCountInLogger;
    void print(String message) {
        if (message != null) {
               if (message.equals("end")) {
                message = message + "\n end calc process";
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("src/by/it/rumiantcau/calc/log.txt", true))) {
                exceptionCountInLogger++;
                writer.println(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
