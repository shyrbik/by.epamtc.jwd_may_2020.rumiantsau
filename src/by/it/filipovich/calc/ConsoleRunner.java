package by.it.filipovich.calc;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer pr = new Printer();
        while (true){
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            else if(expression.equals("printvar")){
                for (Map.Entry<String, Var> pair : Var.vars.entrySet()) {
                    System.out.println(pair);
                }
            }
            else if(expression.equals("sortvar")){
                for (Map.Entry<String, Var> varEntry : new TreeMap<>(Var.vars).entrySet()) {
                    System.out.println(varEntry);
                }
            }
            else {
                try {
                    pr.print(parser.calc(expression));
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
