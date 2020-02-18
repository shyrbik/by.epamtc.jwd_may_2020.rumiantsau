package by.it.filipovich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        Var result = null;
        expression = expression.replaceAll("\\s","");
        Matcher matcher = Pattern.compile(Patterns.OPERATIONS).matcher(expression);
        if(matcher.find()){
            String[] operand = expression.split(Patterns.OPERATIONS);
            Var operand2 = Var.createVar(operand[1]);
            String mark = matcher.group();
            if(mark.equals("=")) {
                Var.save(operand[0], operand2);
                return operand2;
            }
            Var operand1 = Var.createVar(operand[0]);

            switch (mark) {
            case "+":
                result = operand1.add(operand2);
            break;
            case "-":
                result = operand1.sub(operand2);
            break;
            case "*":
                result = operand1.mul(operand2);
                break;
            case "/":
                result = operand1.div(operand2);
                break;
            default:
                System.out.println("Unknown Operation!!!");
                break;
        }
        return result;
        }
        return null;
    }
}
