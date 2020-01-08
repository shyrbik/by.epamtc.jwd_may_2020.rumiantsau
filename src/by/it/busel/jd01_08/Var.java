package by.it.busel.jd01_08;

class Var implements Operation {
    protected static int counter;
    @Override
    public String toString() {
        return "exampleVar.toString()";
    }

    @Override
    public Var add(Var other) {
        System.out.println("The operation \"addition\" " + this + " + " + other + " can not be performed.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("The operation \"subtraction\" " + this + " - " + other + " can not be performed.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("The operation \"multiplication\"" + this + " * " + other + " can not be performed.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("The operation \"division\"" + this + " / " + other + " can not be performed.");
        return null;
    }
}
