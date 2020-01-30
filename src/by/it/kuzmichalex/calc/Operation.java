package by.it.kuzmichalex.calc;

public interface Operation {
    Var add(Var rightOperand);

    Var sub(Var rightOperand);

    Var mul(Var rightOperand);

    Var div(Var rightOperand);
}
