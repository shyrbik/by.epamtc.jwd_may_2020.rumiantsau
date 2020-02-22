package by.it.lozouski.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> mapOperationPriority = new HashMap<>();

    static {
        mapOperationPriority.put("=", 0);
        mapOperationPriority.put("+", 1);
        mapOperationPriority.put("-", 1);
        mapOperationPriority.put("*", 2);
        mapOperationPriority.put("/", 2);
    }

    private int getIndexOperation(List<String> listOperations) {
        int indexOperation = -1;
        int currentPriorityOperation = -1;
        for (int i = 0; i < listOperations.size(); i++) {
            String operation = listOperations.get(i);
            if (mapOperationPriority.get(operation) > currentPriorityOperation) {
                indexOperation = i;
                currentPriorityOperation = mapOperationPriority.get(operation);
            }
        }
        return indexOperation;
    }

    private Var calculateOneOperation(String leftOperand, String operationType, String rightOperand) throws CalcException {
        Var rightOper = Var.createVar(rightOperand);
        if (operationType.equals("=")) {
            Var.saveVar(leftOperand, rightOper);
            return rightOper;
        }

        Var leftOper = Var.createVar(leftOperand);
        if (leftOper != null && rightOper != null) {
            switch (operationType) {
                case "+":
                    return leftOper.add(rightOper);
                case "-":
                    return leftOper.sub(rightOper);
                case "*":
                    return leftOper.mul(rightOper);
                case "/":
                    return leftOper.div(rightOper);
            }
        }
        throw new CalcException("Incorrect variable creation, please try again.");
    }


    Var calculate(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");

        List<String> operandsList = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operationsList = new ArrayList<>();

        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            String operation = matcher.group();
            operationsList.add(operation);
        }

        while (operationsList.size() > 0) {
            try {
                int i = getIndexOperation(operationsList);
                String operation = operationsList.remove(i);
                String leftOperand = operandsList.remove(i);
                String rightOperand = operandsList.remove(i);
                Var resultOperations = calculateOneOperation(leftOperand, operation, rightOperand);
                operandsList.add(i, resultOperations.toString());
            }catch (IndexOutOfBoundsException e){
                throw new CalcException("Wrong Input! Nothing to calculate. ");
            }

        }
        return Var.createVar(operandsList.get(0));
    }
}
