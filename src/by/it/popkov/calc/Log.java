package by.it.popkov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Log {

    public static void writeLog(String message) {
        try (final PrintWriter logName = new PrintWriter
                (new FileWriter(CalcFile.fileFullName(Log.class, "log.txt"), true))) {
            logName.println(message);
        } catch (IOException e) {
            System.out.println("Error writeLog");
        }
    }
}
