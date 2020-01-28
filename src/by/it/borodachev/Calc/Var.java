package by.it.borodachev.Calc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Var implements Operation {
     private static Map<String, Var> field=new HashMap<>();

     @Override
     public String toString() {
          return "Var{}";
     }

     @Override
     public Var add(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var sub(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var mul(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var div(Var newValue) throws Exception{
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }
     static Var createVar(String strVar) throws Exception {
          if (strVar.matches(Patterns.SCALAR))
               return new Scalar(strVar);
          else if (strVar.matches(Patterns.VECTOR))
               return new Vector(strVar);
          else if (strVar.matches(Patterns.MATRIX))
               return new Matrix(strVar);
          else
               return field.get(strVar);
          //TODO generate error here
     }
     static void save(String key, Var value) {
          field.put(key,value);
     }

     static void printvar() {
          for (Map.Entry<String, Var> stringVarEntry : field.entrySet()) {
               System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
          }
     }
     static void sortvar() {
          Set<String> strings = field.keySet();
          Object[] objects = strings.toArray();
          Arrays.sort(objects);
          for (Object object : objects) {
               System.out.println(object+"="+field.get(object));
          }
     }
}
