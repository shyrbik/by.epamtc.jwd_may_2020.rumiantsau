package by.it.lozouski.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        return null;
    }
    Var add(Scalar otherScalar){
        System.out.println("Operation addition " + otherScalar + " + " + this + " isn't possible.");
        return null;
    }
    Var add(Vector otherVector){
        System.out.println("Operation addition " + otherVector + " + " + this + " isn't possible.");
        return null;
    }
    Var add(Matrix otherMatrix){
        System.out.println("Operation addition " + otherMatrix + " + " + this + " isn't possible.");
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
