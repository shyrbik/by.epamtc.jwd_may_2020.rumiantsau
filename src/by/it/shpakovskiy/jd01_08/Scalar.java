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

    private Var getResult(Var other, String operation) {
        if (other.getClassName().equals("Scalar")) {
            Scalar otherScalar = (Scalar) other;
            if (operation.equals("add")) {
                return new Scalar(this.value + otherScalar.value);
            }
            if (operation.equals("sub")){
                return new Scalar(this.value - otherScalar.value);
            }
            if (operation.equals("mul")){
                return new Scalar(this.value * otherScalar.value);
            }
            if (operation.equals("div")){
                return new Scalar(this.value / otherScalar.value);
            }
        }
        return getDefaultResult(this);
    }

    @Override
    public Var add(Var other) {
        return getResult(other,"add");
    }

    @Override
    public Var sub(Var other) {
        return getResult(other,"sub");
    }

    @Override
    public Var mul(Var other) {
        return getResult(other,"mul");
    }

    @Override
    public Var div(Var other) {
        return getResult(other,"div");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}