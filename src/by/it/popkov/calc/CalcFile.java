package by.it.popkov.calc;

import java.io.File;

class CalcFile {
    static private String fullFileName = fileFullName(Var.class, "value.txt");

    public static String fileFullName(Class<?> taskClass, String fileName) {
        String projectDir = System.getProperty("user.dir");
        String classPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + classPath + fileName;
    }
}
