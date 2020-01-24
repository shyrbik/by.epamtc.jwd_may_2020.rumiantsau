package by.it.popkov.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        while (true) {
            String expression = scanner.next();
            if (expression.equals("end")) break;
            if (expression.equals("printvar")) Var.printvar();
            if (expression.equals("sortvar")) Var.sortvar();
            printer.print(parser.calc(expression));
        }
    }

}
