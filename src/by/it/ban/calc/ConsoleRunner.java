package by.it.ban.calc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static by.it.ban.calc.Var.printvar;
import static by.it.ban.calc.Var.sortvar;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        LogFile log = null;
        log = new LogFile();
        VarFile.load();
        while (true) {
            String expression = scanner.next();
            if (expression.equals("end")) {
                log.close();
                break;
            }
            if (expression.equals("printvar")) {
                printvar();
            } else if (expression.equals("sortvar")) {
                sortvar();
            }else {
                Var result = null;
                try {
                    log.print(expression);
                    result = parser.calc(expression);
                    if (result != null) printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    log.print(e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
