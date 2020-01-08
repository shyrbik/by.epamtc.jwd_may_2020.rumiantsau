package by.it.busel.jd01_08;

/**
 * a class that is a general specimen of a math expression
 */
class Var implements Operation {
    @Override
    public String toString() {
        return "exampleVar.toString()";
    }

    /**
     * a method that informs whether a mathematical operation of addition can not be performed
     * @param other an instance of Var-class or its subclasses, which is to be added
     * @return a result of addition
     */
    @Override
    public Var add(Var other) {
        System.out.println("The operation \"addition\" " + this + " + " + other + " can not be performed.");
        return null;
    }

    /**
     * a method that informs whether a mathematical operation of subtraction can not be performed
     * @param other an instance of Var-class or its subclasses, which is to be subtracted
     * @return a result of subtraction
     */
    @Override
    public Var sub(Var other) {
        System.out.println("The operation \"subtraction\" " + this + " - " + other + " can not be performed.");
        return null;
    }

    /**
     * a method that informs whether a mathematical operation of multiplication can not be performed
     * @param other an instance of Var-class or its subclasses, which is a multiplier
     * @return a result of a multiplication
     */
    @Override
    public Var mul(Var other) {
        System.out.println("The operation \"multiplication\" " + this + " * " + other + " can not be performed.");
        return null;
    }

    /**
     * a method that informs whether a mathematical operation of division can not be performed
     * @param other an instance of Var-class or its subclasses, which is divisor
     * @return a result of division
     */
    @Override
    public Var div(Var other) {
        System.out.println("The operation \"division\" " + this + " / " + other + " can not be performed.");
        return null;
    }
}
