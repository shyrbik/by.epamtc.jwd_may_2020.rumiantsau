package by.it.kuzmichalex.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            try {
                String expression = scanner.next();
                if (expression.equals(KeyWords.PRINTVAR)) {
                    System.out.println(Var.printVars());
                    continue;
                }
                if (expression.equals(KeyWords.SORTVAR)) {
                    System.out.println(Var.sortVars());
                    continue;
                }
                if (expression.equals("end") || expression.equals("exit") || expression.equals("quit")) break;
                Var result = parser.calc(expression);
                printer.print(result);
            }
            catch (CalcException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
