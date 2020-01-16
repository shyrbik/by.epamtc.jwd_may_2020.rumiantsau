package by.it.shpakovskiy.jd01_08;

abstract class Var implements Operation {
    abstract String getClassName();

    Var getDefaultResult(Var other) {
        System.out.println("Operation with " + other + " impossible");
        return null;
    }
}
