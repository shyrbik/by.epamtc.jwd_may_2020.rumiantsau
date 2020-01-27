package by.it.busel.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Storage storage = new Storage();
        while (true) {
            String varExpression = scanner.next();
            ConsoleCommands.call(varExpression);
            if (!varExpression.equals("end") && !varExpression.equals("конец")) {
                Var result = parser.calc(varExpression.trim());
                printer.print(result);
            } else {
                break;
            }
        }

    }
}
