package by.it.lozouski.jd01_14;

import java.io.File;

public class Helper {

    static String getPath(String fileName, Class<?> yourClass){
        String dir = System.getProperty("user.dir");
        String packageName = yourClass.getName().replace(yourClass.getSimpleName(),"");
        String path = dir + File.separator + "src" + File.separator + packageName.replace(".", File.separator);
        fileName = path + fileName;
        return fileName;
    }
}
