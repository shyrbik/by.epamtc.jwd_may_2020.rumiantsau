package by.it.popkov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

class Log {
    static private final String logFullName = CalcFile.fileFullName(Log.class, "log.txt");

    static private int messageCounter = 0;

    public static void reWriteLog(String newMessage) {
        int posForNewMassage = messageCounter % 50;
        try {
            List<String> lines = Files.lines(Paths.get(logFullName)).collect(Collectors.toList());
            lines.remove(posForNewMassage);
            lines.add(posForNewMassage, newMessage);
            Files.write(Paths.get(logFullName), lines);
        } catch (IOException e) {
            System.out.println("Error reWriteLog");
        }
    }

    public static void writeLog(String message) {
        String now = LocalDateTime.now() + ": ";
        if (messageCounter >= 50) reWriteLog(now + message);
        else {
            try (final PrintWriter logName = new PrintWriter
                    (new FileWriter(logFullName, true))) {
                logName.println(now + message);
            } catch (IOException e) {
                System.out.println("Error writeLog");
            }
        }
        messageCounter++;
    }
}
