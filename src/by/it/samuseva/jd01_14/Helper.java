package by.it.samuseva.jd01_14;

import java.io.File;

public class Helper {
    static String getDirectory (String fileName, Class<?> aClass) {
        String pathDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathFolder = aClass.getName().replace(aClass.getSimpleName(), "").replace(".", File.separator);
        return pathDir+pathFolder+fileName;
    }
}
