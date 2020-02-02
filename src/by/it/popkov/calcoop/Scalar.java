package by.it.popkov.calcoop;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) throws CalcException {
        return new Scalar(this.value + other.value);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return new Scalar(-1).mul(other.sub(this));
    }

    @Override
    public Var sub(Scalar other) throws CalcException {
        return new Scalar(this.value - other.value);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }
    @Override
    public Var mul(Scalar other) throws CalcException {
        return new Scalar(this.value*other.value);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) {
                throw new CalcException("Деление на 0");
            }
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(other);
    }
}
