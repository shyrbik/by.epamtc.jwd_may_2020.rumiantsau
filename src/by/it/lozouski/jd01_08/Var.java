package by.it.lozouski.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Operation addition " + this + " + " + other + " isn't possible.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation subtraction " + this + " - " + other + " isn't possible.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation multiplication " + this + " * " + other + " isn't possible.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation division " + this + " / " + other + " isn't possible.");
        return null;
    }
}
