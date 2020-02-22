package by.it.kuzmichalex.jd02_04_calc;

public class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replace("\\s+", "");
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] partsOfExpression = expression.split("=");
        if (partsOfExpression.length == 1) {
            rpn.parseExpression(expression);
            return rpn.calc();
        } else if (partsOfExpression.length == 2) {
            rpn.parseExpression(partsOfExpression[1]);
            Var rightVar=rpn.calc();
            Var.save(partsOfExpression[0],rightVar);
            return rightVar;
        } else throw new CalcException("expression is little wrong");
    }



}
