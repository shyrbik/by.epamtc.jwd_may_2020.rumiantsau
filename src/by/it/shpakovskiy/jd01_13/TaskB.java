package by.it.shpakovskiy.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        while (true) {
            String line = scanner.next();
            if (line.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(line);
                System.out.println("You entered: " + number);
                result += number;
                System.out.println("Result: " + Math.sqrt(result));
            } catch (NumberFormatException e) {
                System.err.println("name: " + e.getClass().getName());
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        System.err.println("class: " + stackTraceElement.getClassName());
                        System.err.println("line: " + stackTraceElement.getLineNumber());
                    }
                }
            }
        }
    }
}
