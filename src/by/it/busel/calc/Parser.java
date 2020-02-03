package by.it.busel.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    /**
     * a method, which calculates some mathematical operations
     * on the basis of the argument "String varExpression",
     * which contains a mathematical operator and its operands
     * received from console input by the means of a Scanner-object
     *
     * @param varExpression a String-object, which contains
     *                      a mathematical operator and its operands
     *                      received from console input by the means
     *                      of a Scanner-object
     * @return a result of a mathematical operation,
     * i.e. a Scalar / Vector / Matrix expression
     */
    Var calc(String varExpression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operand = pattern.split(varExpression);
//        Var operand1 = Var.createVar(operand[0].trim());
//        Var operand2 = Var.createVar(operand[1].trim());
//        if (operand1 == null || operand2 == null) {
//            return null;
//        }
        Matcher matcher = pattern.matcher(varExpression);
        if (matcher.find()) {
            String operator = matcher.group();
            Var operand2 = Var.createVar(operand[1].trim());
            if (operator.equals("=")) {
                Storage.putMapElement(operand[0], operand2);
                return operand2;
            }
            Var operand1 = Var.createVar(operand[0].trim());
            if (operand1 == null || operand2 == null) {
                return null;
            }
            switch (operator) {
                case "+":
                    return operand1.add(operand2);
                case "-":
                    return operand1.sub(operand2);
                case "*":
                    return operand1.mul(operand2);
                case "/":
                    return operand1.div(operand2);
//                case "=":
//                    Storage.putMapElement(operand[0].toUpperCase(), operand2);
//                    return operand2;
                default:
                    throw new CalcException("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
            }
        }
        throw new CalcException("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
    }
}
