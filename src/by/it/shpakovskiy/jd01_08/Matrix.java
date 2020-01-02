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
        value = matrix.value;
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
            double[][] result = getArrayCopy(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        if (other.getClassName().equals("Scalar")) {
            double[][] result = getArrayCopy(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other.getClassName().equals("Matrix")) {
            Matrix matrix = (Matrix) other;
            if (matrix.value.length == value.length) {
                double[][] result = getArrayCopy(value);
                for (int i = 0; i < result.length; i++) {
                    if (matrix.value[i].length == value[i].length) {
                        for (int j = 0; j < result.length; j++) {
                            result[i][j] -= matrix.value[i][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        if (other.getClassName().equals("Scalar")) {
            double[][] result = getArrayCopy(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other.getClassName().equals("Scalar")) {
            double[][] result = getArrayCopy(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] *= ((Scalar) other).getValue();
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
            Matrix matrix = (Matrix) other;
            if (matrix.value.length == value.length) {
                double[][] result = new double[value.length][value.length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value.length; j++) {
                        for (int k = 0; k < value.length; k++) {
                            result[i][j] += value[i][k] * matrix.value[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
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

    private double[][] getArrayCopy(double[][] arr) {
        double[][] result = new double[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}
