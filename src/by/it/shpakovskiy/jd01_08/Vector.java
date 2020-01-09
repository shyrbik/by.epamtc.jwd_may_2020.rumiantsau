package by.it.shpakovskiy.jd01_08;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{|}]", "");
        String[] stringValue = strVector.split(",");
        value = new double[stringValue.length];
        for (int i = 0; i < stringValue.length; i++) {
            value[i] = Double.parseDouble(stringValue[i].trim());
        }
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    String getClassName() {
        return "Vector";
    }

    private Var getResultOperationWithScalar(Var other, String operation) {
        Scalar scalar = (Scalar) other;
        double[] resultValue = new double[value.length];
        if (operation.equals("add")) {
            for (int i = 0; i < value.length; i++) {
                resultValue[i] = value[i] + scalar.getValue();
            }
        }
        if (operation.equals("sub")) {
            for (int i = 0; i < value.length; i++) {
                resultValue[i] = value[i] - scalar.getValue();
            }
        }
        if (operation.equals("mul")) {
            for (int i = 0; i < value.length; i++) {
                resultValue[i] = value[i] * scalar.getValue();
            }
        }
        if (operation.equals("div")) {
            for (int i = 0; i < value.length; i++) {
                resultValue[i] = value[i] / scalar.getValue();
            }
        }
        return new Vector(resultValue);
    }

    private Var getResultAddOrSubVector(Var other, int sign) {
        Vector otherVector = (Vector) other;
        if (otherVector.getValue().length == value.length) {
            double[] resultValue = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                resultValue[i] = value[i] + sign * otherVector.value[i];
            }
            return new Vector(resultValue);
        }
        return getDefaultResult(this);
    }

    @Override
    public Var add(Var other) {
        if (other.getClassName().equals("Scalar")) {
            return getResultOperationWithScalar(other, "add");
        }
        if (other.getClassName().equals("Vector")) {
            return getResultAddOrSubVector(other, 1);
        }
        return getDefaultResult(this);
    }

    @Override
    public Var sub(Var other) {
        if (other.getClassName().equals("Scalar")) {
            return getResultOperationWithScalar(other, "sub");
        }
        if (other.getClassName().equals("Vector")) {
            return getResultAddOrSubVector(other, -1);
        }
        return getDefaultResult(other);
    }

    @Override
    public Var mul(Var other) {
        if (other.getClassName().equals("Scalar")) {
            return getResultOperationWithScalar(other, "mul");
        }
        if (other.getClassName().equals("Vector")) {
            Vector otherVector = (Vector) other;
            if (otherVector.getValue().length == value.length) {
                double result = 0;
                for (int i = 0; i < value.length; i++) {
                    result += otherVector.value[i] * value[i];
                }
                return new Scalar(result);
            }
        }
        return getDefaultResult(other);
    }

    @Override
    public Var div(Var other) {
        if (other.getClassName().equals("Scalar")) {
            return getResultOperationWithScalar(other, "div");
        }
        return getDefaultResult(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}