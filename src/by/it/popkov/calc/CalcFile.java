package by.it.popkov.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

class CalcFile {
    static private String fullFileName = fileFullName(Var.class, "vars.txt");

    static void writeToFile(Map<String, Var> valueMap) throws CalcException {
        try(PrintWriter printWriter = new PrintWriter(fullFileName)) {
            for (Map.Entry<String, Var> entry : valueMap.entrySet()) {
                printWriter.printf("%s=%s"+"\n", entry.getKey(), entry.getValue().toString());
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new CalcException("ERROR writeToFile");
        }
    }
























    static String fileFullName(Class<?> taskClass, String fileName) {
        String projectDir = System.getProperty("user.dir");
        String classPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + classPath + fileName;
    }
}
