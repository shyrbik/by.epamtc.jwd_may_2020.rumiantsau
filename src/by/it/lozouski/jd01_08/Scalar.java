package by.it.lozouski.jd01_08;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String text) {
        this.value = Double.parseDouble(text);
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    Var add(Scalar otherScalar) {
        double sum = this.value + otherScalar.value;
        return new Scalar(sum);
    }

    @Override
    Var add(Vector otherVector) {
       return otherVector.add(this);
    }

    @Override
    Var add(Matrix otherMatrix) {
        return otherMatrix.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
