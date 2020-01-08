package by.it.busel.jd01_08;

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
            return this.add(other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.add(other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.add(other);
    }

    public Var add(Scalar other) throws ClassCastException {
        double sum = this.value + other.value;
        return new Scalar(sum);
    }

//    public Var add(Vector other) throws ClassCastException {
//        return new Vector(other);
//    }
//
//    public Var add(Matrix other) throws ClassCastException {
//
//        return new Matrix(other);
//    }

    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.sub(other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.sub(other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.sub(other);
    }

    private Var sub(Scalar other) {
        double rem = this.value - other.value;
        return new Scalar(rem);
    }

    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.mul(other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.mul(other);
        } catch (ClassCastException e) {
            counter++;
        }

        return super.mul(other);
    }

    public Var mul(Scalar other) {
        double mul = this.value * other.value;
        return new Scalar(mul);
    }

    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.div(other);
        } catch (ClassCastException e) {
            counter++;
        }

        try {
            return this.div(other);
        } catch (ClassCastException e) {
            counter++;
        }
        return super.div(other);
    }

    private Var div(Scalar other) {
        double div = this.value / other.value;
        return new Scalar(div);
    }

}
