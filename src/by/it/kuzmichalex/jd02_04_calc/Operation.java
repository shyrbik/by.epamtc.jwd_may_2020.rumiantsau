package by.it.kuzmichalex.jd02_04_calc;

public interface Operation {
    Var add(Var rightOperand) throws CalcException;

    Var sub(Var rightOperand) throws CalcException;

    Var mul(Var rightOperand) throws CalcException;

    Var div(Var rightOperand) throws CalcException;
}
