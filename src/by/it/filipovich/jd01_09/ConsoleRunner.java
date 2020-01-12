package by.it.filipovich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        Parser parser = new Parser();
        print(parser.calc(expression));


    }

    private static void print(Var var){
        if(var != null)
            System.out.println(var);
    }
}
