package by.it.filipovich.calc;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer pr = new Printer();
        label:
        while (true){
            String expression = scanner.nextLine();
            switch (expression) {
                case "end":
                    break label;
                case "printvar":
                    for (Map.Entry<String, Var> pair : Var.vars.entrySet()) {
                        System.out.println(pair);
                    }
                    break;
                case "sortvar":
                    for (Map.Entry<String, Var> varEntry : new TreeMap<>(Var.vars).entrySet()) {
                        System.out.println(varEntry);
                    }
                    break;
                default:
                    try {
                        pr.print(parser.calc(expression));
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
