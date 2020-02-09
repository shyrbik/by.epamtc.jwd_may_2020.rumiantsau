package by.it.lozouski.calc;

import java.io.IOException;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc1 = new Scanner(System.in);
        String inputLine;
        Parser parser = new Parser();
        Printer printer = new Printer();
        VarFile.load(new Parser());
        while (!(inputLine = sc1.nextLine()).equals("end")) {
            try {
                Var result = parser.calculate(inputLine);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
