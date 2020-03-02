package by.it.lozouski.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    static ChangeLangService langService = ChangeLangService.START;

    private static Map<String, Var> varsMap = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException();
    }

    Var add(Scalar otherScalar) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_ADD) + otherScalar + " + " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var add(Vector otherVector) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_ADD) + otherVector + " + " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var add(Matrix otherMatrix) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_ADD) + otherMatrix + " + " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException();
    }

    Var sub(Scalar otherScalar) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_SUB) + otherScalar + " - " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var sub(Vector otherVector) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_SUB) + otherVector + " - " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var sub(Matrix otherMatrix) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_SUB) + otherMatrix + " - " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException();
    }

    Var mul(Scalar otherScalar) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_MUL) + otherScalar + " * " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var mul(Vector otherVector) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_MUL) + otherVector + " * " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var mul(Matrix otherMatrix) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_MUL) + otherMatrix + " * " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_DIV) + this + " / " + other + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var div(Scalar otherScalar) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_DIV) + otherScalar + " / " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }

    Var div(Vector otherVector) throws CalcException {
        throw new CalcException(langService.get(Error.ERR_OPERATION_DIV) + otherVector + " / " + this + langService.get(Error.ERR_IS_IMPOSSIBLE));
    }


    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        else if (operand.matches(Patterns.VARNAME)) {
            if (varsMap.get(operand) == null)
                throw new CalcException(langService.get(Messages.MES_UNDEFINED_VAR) + '"' + operand + '"' + "." +
                        "\n" + langService.get(Messages.MES_VALUE_FORMAT));
            return varsMap.get(operand);
        } else throw new CalcException(langService.get(Error.ERR_INCORRECT_INPUT));
    }

    static void saveVar(String key, Var value) throws CalcException {
        if (!key.matches(Patterns.VARNAME)) {
            throw new CalcException(langService.get(Error.ERR_WRONG_VAR_NAME) + '\n'
                    + langService.get(Messages.MES_VAR_FORMAT) + '\n'
                    + langService.get(Messages.MES_LETTERS_FORMAT));
        }
        varsMap.put(key, value);
        VarFile.save(varsMap);
    }

    static void printStorageVar() {
        if (varsMap.size() > 0) {
            System.out.println(langService.get(Messages.MES_SAVED_VAR));
        } else {
            System.out.println(langService.get(Messages.MES_SAVED_VAR) + '\n' + langService.get(Messages.MES_MEMORY_EMPTY));
        }
        for (Map.Entry<String, Var> entry : varsMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
