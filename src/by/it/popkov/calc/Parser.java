package by.it.popkov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        Log.writeLog(expression);
        expression = expression.replace("\\s+", "");
        Matcher m = Pattern.compile(Patterns.MATH_SIGN).matcher(expression);
        if (m.find()) {
            String sing = m.group();
            String[] values = expression.split(Patterns.MATH_SIGN);
            Var second = Var.newVar(values[1]);
            if (sing.equals("=")){
                Var.save(values[0], second);
                return second;
            }
            Var first = Var.newVar(values[0]);
            if (first != null && second != null) {
                switch (sing) {
                    case "+":
                        return first.add(second);
                    case "-":
                        return first.sub(second);
                    case "*":
                        return first.mul(second);
                    case "/":
                        return first.div(second);

                }
            }
        }
        throw new CalcException("Ошибка ввода");
    }
}
