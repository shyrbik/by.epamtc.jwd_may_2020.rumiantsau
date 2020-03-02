package by.it.lozouski.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ChangeLangService langService = ChangeLangService.START;
        Logging.logFileRecord(langService.get(Log.LOG_PROG_START));

        try {
            if (Files.exists(Paths.get(VarFile.getVarFile()))){
                VarFile.load(parser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            String inputLine = sc1.nextLine();
            if (inputLine.equals("end")) {
                Logging.logFileRecord(langService.get(Log.LOG_PROG_FINISH));
                break;
            }
            else if(inputLine.equals("printvar")) Var.printStorageVar();
            else if (inputLine.equals("en")) langService.setLocale(new Locale("en","US"));
            else if (inputLine.equals("ru")) langService.setLocale(new Locale("ru","RU"));
            else if (inputLine.equals("be")) langService.setLocale(new Locale("be","BY"));
            else try {
                Logging.logFileRecord(inputLine);
                Var result = parser.calculate(inputLine);
                printer.print(result);
                Logging.logFileRecord(langService.get(Log.LOG_RESULT) + result.toString());
            } catch (CalcException e) {
                Logging.logFileRecord(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
