package by.it.kuzmichalex.jd01_07;

class Scalar extends Var {
    double value;

    /**
     * constructor
     *
     * @param value double value
     */
    Scalar(double value) {
        this.value = value;
    }

    /**
     * constructor
     *
     * @param scalar scalar value
     */
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    /**
     * constructor
     */
    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    /**
     * Override Var.toString method
     */
    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
