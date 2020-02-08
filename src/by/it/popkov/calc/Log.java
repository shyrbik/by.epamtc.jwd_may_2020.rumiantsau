package by.it.popkov.calc;


/**
 * ПРОТЕСТИРОВАТЬ ЕЩЁ
 **/


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

class Log {
    static private final String logFullName = CalcFile.fileFullName(Log.class, "log.txt");


    public static void reWriteLog(String newMessage) {

        try {
            List<String> lines = Files.lines(Paths.get(logFullName)).collect(Collectors.toList());
            lines.remove(0);
            lines.add(newMessage);
            Files.write(Paths.get(logFullName), lines);
        } catch (IOException e) {
            System.out.println("Error reWriteLog");
        }
    }

    public static void writeLog(String message) {
        String now = LocalDateTime.now() + ": ";
        try {
            if (Files.exists(Paths.get(logFullName)) && Files.readAllLines(Paths.get(logFullName)).size() >= 50)
                reWriteLog(now + message);
            else {
                try (final PrintWriter logName = new PrintWriter
                        (new FileWriter(logFullName, true))) {
                    logName.println(now + message);
                } catch (IOException e) {
                    System.out.println("Error writeLog");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


//    static private final String messageCounterFile = CalcFile.fileFullName(Log.class, "messageCounter.bin");
//
//    static private int messageCount = messageCounterReader();
//
//    private static int messageCounterReader() {
//        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(messageCounterFile)))) {
//            while (dataInputStream.available() > 0) return dataInputStream.readInt();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static int messageCounterWriter(int newNum) {
//        try {
//            RandomAccessFile rwd = new RandomAccessFile(messageCounterFile, "rwd");
//            if (Files.exists(Paths.get(messageCounterFile))) ;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }