package by.it.filipovich.jd01_08;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("Operating for "+this+" + "+ other + " is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operating for "+this+" - "+ other + " is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operating for "+this+" * "+ other + " is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operating for "+this+" / "+ other + " is impossible");
        return null;
    }

    @Override
    public String toString(){
        return "Я метод Var, я не хочу ничего решать!";
    }
}
