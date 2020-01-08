package by.it.shpakovskiy.jd01_08;

abstract class Var implements Operation {
    abstract String getClassName();
    @Override
    public Var add(Var other) {
        System.out.println("Operation with " + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation with " + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation with " + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation with " + other + " impossible");
        return null;
    }
}
