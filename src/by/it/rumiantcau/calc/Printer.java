package by.it.rumiantcau.calc;

class Printer {
    void print(Var var) throws CalcException {
        if (var != null) System.out.println(var);
        else throw new CalcException("Null Pointer Exception");
    }
}
