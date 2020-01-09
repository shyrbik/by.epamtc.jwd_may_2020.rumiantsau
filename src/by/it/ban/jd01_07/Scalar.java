package by.it.ban.jd01_07;

public class Scalar extends Var {
    public double value;
    Scalar(double value) {
        this.value=value;
    }

    Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
