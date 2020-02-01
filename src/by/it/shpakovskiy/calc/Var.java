package by.it.shpakovskiy.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var add(Scalar other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var add(Vector other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var add(Matrix other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var sub(Scalar other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var sub(Vector other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var sub(Matrix other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var mul(Scalar other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var mul(Vector other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var mul(Matrix other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var div(Scalar other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var div(Vector other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var div(Matrix other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else
            return vars.get(strVar);
    }

    static void saveVar(String key, Var value) {
        vars.put(key, value);
    }

    public static String getStringVars() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String varName : vars.keySet()) {
            stringBuilder.append(varName)
                    .append("=")
                    .append(vars.get(varName))
                    .append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void sortAndPrintVars() {
        Set<String> set = new TreeSet<>(vars.keySet());
        for (String s : set) {
            System.out.println(s + "=" + vars.get(s));
        }
    }
}
