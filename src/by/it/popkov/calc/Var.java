package by.it.popkov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

abstract class Var implements Operation {

    private static Map<String, Var> valueMap = new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.println(this + " + " + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println(this + " - " + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println(this + " * " + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println(this + " / " + other + " impossible");
        return null;
    }

    static Var newVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (strVar.matches(Patterns.LITTER)) return valueMap.get(strVar);
        else return null;
    }

    static void save(String value, Var value1) {
        valueMap.put(value, value1);
    }
    static void printvar (){
        System.out.println(valueMap);
//        String[] keys = valueMap.keySet().toArray(new String[0]);
//        for (String key : keys) {
//            System.out.println(key + "="+ valueMap.get(key));
//        }
    }
    static void sortvar(){
        System.out.println(new TreeMap<>(valueMap));
//        TreeSet<String> objects = new TreeSet<>(valueMap.keySet());
//        String[] sortedKeys = objects.toArray(new String[0]);
//        for (String sortedKey : sortedKeys) {
//            System.out.println(sortedKey + "="+ valueMap.get(sortedKey));
        //}
    }
}
