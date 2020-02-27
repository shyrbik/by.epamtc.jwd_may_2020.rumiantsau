package by.it.popkov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map<String, Var> valueMap = new HashMap<>();

    
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    Var preAdd(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var add(Scalar other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var add(Vector other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var add(Matrix other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    Var preSub(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var sub(Scalar other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var sub(Vector other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var sub(Matrix other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }
    Var preMul(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var mul(Scalar other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var mul(Vector other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var mul(Matrix other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    Var preDiv(Var other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }

    public Var div(Scalar other) throws CalcException {
        throw new CalcException(Error.IMPOSSIBLE);
    }


    static Var newVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (strVar.matches(Patterns.LITTER)) return valueMap.get(strVar);
        else throw new CalcException(Error.INPUT_ERROR);
    }

    static void save(String value, Var value1) throws CalcException {
        valueMap.put(value, value1);
        CalcFile.writeValue(valueMap);
    }

    static void printvar() {
        String values = valueMap.toString();
        System.out.println(values);
//        Log.writeLog(values);

    }

    static void sortvar() {
        final String sortedValue = new TreeMap<>(valueMap).toString();
        System.out.println(sortedValue);
//        Log.writeLog(sortedValue);

    }
}
