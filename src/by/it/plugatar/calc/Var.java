package by.it.plugatar.calc;
/*          Sacalar       Vector            Matrix
* Scalar   +-* делить     +-* делить нет    +-* делить нет
*
* Vector   +-*делить мож  +-*делить нет     нет нет нет нет
*
* Matrix   +-*делить с      умножение с огран + - * с ограничени
*           ограничен
* */
/*
abstract class Var {
    @Override
    public String toString(){
        return "Это класс Var";
    }
}
*/

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

   private static Map<String, Var> vars = new HashMap<>();
   static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }


    static Var createVar(String s) {
        //s = s.trim();
        s = s.trim().replace("\\s+","");
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        if (vars.containsKey(s)) return vars.get(s);//Если содержит, то вернем соответствующий объект
        System.out.println("Переменная " + s + " не определена");
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления" + this + "+" + other + " невозможна");
        return null;
    }
}



