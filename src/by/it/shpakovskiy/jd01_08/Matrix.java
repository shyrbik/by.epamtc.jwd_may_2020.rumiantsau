package by.it.shpakovskiy.jd01_08;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];
            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                value[i] = tempArr;
            }
        }
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    String getClassName() {
        return "Matrix";
    }

    @Override
    public Var add(Var other) {
        if (other.getClassName().equals("Matrix")) {
            Matrix otherMatrix = (Matrix) other;
            if (otherMatrix.value.length == value.length) {
                double[][] result = new double[value.length][value.length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result.length; j++) {
                        result[i][j] = value[i][j] + otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }
        if (other.getClassName().equals("Scalar")) {
            double[][] result = new double[value.length][value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return getDefaultResult(other);
    }

    @Override
    public Var sub(Var other) {
        if (other.getClassName().equals("Matrix")) {
            Matrix otherMatrix = (Matrix) other;
            if (otherMatrix.value.length == value.length) {
                double[][] result = new double[value.length][value.length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result.length; j++) {
                        result[i][j] = value[i][j] - otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }
        if (other.getClassName().equals("Scalar")) {
            double[][] result = new double[value.length][value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return getDefaultResult(other);
    }

    @Override
    public Var mul(Var other) {
        if (other.getClassName().equals("Scalar")) {
            double[][] result = new double[value.length][value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        if (other.getClassName().equals("Vector")) {
            double[] vector = ((Vector) other).getValue();
            double[] result = new double[vector.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    result[i] += value[i][j] * vector[j];
                }
            }
            return new Vector(result);
        }
        if (other.getClassName().equals("Matrix")) {
            Matrix otherMatrix = (Matrix) other;
            if (otherMatrix.value.length == value.length) {
                double[][] result = new double[value.length][value.length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value.length; j++) {
                        for (int k = 0; k < value.length; k++) {
                            result[i][j] += value[i][k] * otherMatrix.value[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        return getDefaultResult(other);
    }

    @Override
    public Var div(Var other) {
        return getDefaultResult(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String s = "";
        for (double[] aValue : value) {
            for (double v : aValue) {
                stringBuilder.append(s).append(v);
                s = ", ";
            }
            stringBuilder.append("}");
            s = ", {";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}