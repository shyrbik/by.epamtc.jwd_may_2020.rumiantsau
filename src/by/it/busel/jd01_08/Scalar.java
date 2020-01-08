package by.it.busel.jd01_08;

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

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar() {

    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        try {
            return this.add((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.add((Vector) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.add((Matrix) other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.add(other);
    }

    private Var add(Scalar other) throws ClassCastException {
        double sum = this.value + other.value;
        return new Scalar(sum);
    }

    private Var add(Vector other) throws ClassCastException {
        return other.add(this);
    }

    private Var add(Matrix other) throws ClassCastException {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.sub((Vector) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.sub((Matrix) other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.sub(other);
    }

    private Var sub(Scalar other) throws ClassCastException {
        double rem = this.value - other.value;
        return new Scalar(rem);
    }

    private Var sub(Vector other) throws ClassCastException {
        return new Scalar(-1).mul(other).add(this);
    }

    private Var sub(Matrix other) throws ClassCastException {
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.mul((Vector) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.mul((Matrix) other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.mul(other);
    }

    private Var mul(Scalar other) throws ClassCastException {
        double mul = this.value * other.value;
        return new Scalar(mul);
    }

    private Var mul(Vector other) throws ClassCastException {
        return other.mul(this);
    }

    private Var mul(Matrix other) throws ClassCastException {
        return other.mul(this);
    }


    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.div(other);
    }

    private Var div(Scalar other) throws ClassCastException {
        if (other.value != 0) {
            double div = this.value / other.value;
            return new Scalar(div);
        }
        return super.div(other);
    }

}
