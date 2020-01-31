package by.it.lozouski.calc;

class Patterns {
    static final String OPERATION = "[-+*/=a]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
