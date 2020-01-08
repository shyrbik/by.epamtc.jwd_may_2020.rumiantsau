package by.it.shpakovskiy.jd01_08;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    String getClassName() {
        return "Scalar";
    }

    @Override
    public Var add(Var other) {
        if (other.getClassName().equals("Scalar")) {
            Scalar otherScalar = (Scalar) other;
            return new Scalar(this.value + otherScalar.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other.getClassName().equals("Scalar")) {
            Scalar otherScalar = (Scalar) other;
            return new Scalar(this.value - otherScalar.value);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other.getClassName().equals("Scalar")) {
            Scalar otherScalar = (Scalar) other;
            return new Scalar(this.value * otherScalar.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other.getClassName().equals("Scalar")) {
            Scalar otherScalar = (Scalar) other;
            return new Scalar(this.value / otherScalar.value);
        }
        return other.div(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
