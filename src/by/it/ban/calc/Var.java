package by.it.ban.calc;


import java.util.*;

public abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    @Override
    public String toString() {
        return "Var{}";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }

    @Override
    public Var add(Scalar other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Scalar other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Scalar other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Scalar other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }

    @Override
    public Var add(Vector other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Vector other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Vector other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Vector other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }

    @Override
    public Var add(Matrix other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Matrix other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Matrix other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Matrix other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
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
        //TODO generate error here
    }
    static void save(String key, Var value) {
        vars.put(key,value);
    }

    static void printvar() {
        for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }
    static void sortvar() {
        Set<String> strings = vars.keySet();
        Object[] objects = strings.toArray();
        Arrays.sort(objects);
        for (Object object : objects) {
            System.out.println(object+"="+vars.get(object));
        }
    }
}
