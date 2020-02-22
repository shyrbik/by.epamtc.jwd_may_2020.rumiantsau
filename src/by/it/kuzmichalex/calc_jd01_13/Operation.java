package by.it.kuzmichalex.calc_jd01_13;

public interface Operation {
    Var add(Var rightOperand) throws CalcException;

    Var sub(Var rightOperand) throws CalcException;

    Var mul(Var rightOperand) throws CalcException;

    Var div(Var rightOperand) throws CalcException;
}
