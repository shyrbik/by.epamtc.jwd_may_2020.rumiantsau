package by.it.popkov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

class TaskC {

    static String startFullName = fileFullName(TaskC.class);
    static File file = new File(startFullName);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(file.getAbsolutePath());
            String command = scanner.nextLine();
            if (command.equals("end")) break;
            if (command.contains("cd")) cd(command);
            else if (command.equals("dir")) dir(command);
        }
    }

    private static void cd(String command) {
        String shortCommand = command.replace("cd", "");
        if (shortCommand.matches(" ?..")) {
            file = new File(startFullName.substring(0, 3));
        } else {
            file = new File(file.getAbsolutePath() + File.separator + shortCommand.trim());
        }
    }

    private static void dir(String command) {
        for (File files : file.listFiles()) {
            try {
                Path path = Paths.get(files.getAbsolutePath());
                FileTime modTime = Files.getLastModifiedTime(path);
                String time = modTime.toString();
                String dir = "";
                if (files.isDirectory()) dir = "<DIR>";
                String size = "";
                if (files.isFile()) size = String.valueOf(Files.size(path));
                String name = files.getName();
                System.out.printf("%s %s %s %s\n", time, dir, size, name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String fileFullName(Class<?> taskClass) {
        String projectDir = System.getProperty("user.dir");
        String classPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + classPath;
    }
}
