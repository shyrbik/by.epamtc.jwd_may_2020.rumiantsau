package by.it.ban.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class LogFile {

    static FileWriter out;

    LogFile() throws IOException {
        File file= new File(getPath("log.txt"));
        out = new FileWriter(file,true);
    }
    static String getPath(String fileName) {
        String root = System.getProperty("user.dir");
        String strPackage = LogFile.class.getName().replace(LogFile.class.getSimpleName(), "");
        String path = root + File.separator + "src" + File.separator + strPackage.replace(".", File.separator);
        fileName = path + fileName;
        return fileName;
    }

    static void print(String message) throws IOException {
        out.write(message);
        out.write('\n');
    }
    static void close(){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
