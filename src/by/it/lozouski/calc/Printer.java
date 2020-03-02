package by.it.lozouski.calc;

class Printer {
    void print(Var var) throws CalcException {
        ChangeLangService langService = ChangeLangService.START;
        if (var != null) {
            System.out.println(var);
        } else throw new CalcException(langService.get(Error.ERR_VAR_IS_NULL));
    }
}
