package by.it.lozouski.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][];
        System.arraycopy(matrix.value, 0, this.value, 0, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String temp1 = strMatrix.replaceAll("[\\s]|[{}]{2,}", "");
        String[] temp2 = temp1.replaceAll("[},{]{2,}", "}").replaceAll(",", " ").split("}");
        String[][] tempMatrix = new String[temp2.length][];
        for (int i = 0; i < temp2.length; i++) {
            tempMatrix[i] = temp2[i].split(" ");
        }

        this.value = new double[temp2.length][];
        for (int i = 0; i < value.length; i++) {
            value[i] = new double[tempMatrix[i].length];
            for (int j = 0; j < tempMatrix[i].length; j++) {
                value[i][j] = Double.parseDouble(tempMatrix[i][j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    Var add(Scalar otherScalar) {
        double[][] sum = Arrays.copyOf(value, value.length);
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = sum[i][j] + otherScalar.getValue();
            }
        }
        return new Matrix(sum);
    }

    @Override
    Var add(Matrix otherMatrix) {
        double[][] sum = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                sum[i][j] = this.value[i][j] + otherMatrix.value[i][j];
            }
        }
        return new Matrix(sum);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        }
        if (other instanceof Matrix) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] = result[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            double[] mul = new double[((Vector) other).getValue().length];

            for (int i = 0; i < ((Vector) other).getValue().length; i++) {
                for (int i1 = 0; i1 < ((Vector) other).getValue().length; i1++) {
                    mul[i] = mul[i] + value[i][i1] * ((Vector) other).getValue()[i1];
                }
            }
            return new Vector(mul);
        }
        if (other instanceof Scalar) {
            double[][] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (int i = 0; i < value.length; i++) {
            sb1.append("{");
            for (int j = 0; j < value[i].length; j++) {
                if (j != value[i].length - 1) {
                    sb1.append(joiner).append(value[i][j]).append(", ");
                } else sb1.append(value[i][j]).append("}");
            }
            if (i != value.length - 1) {
                sb1.append(", ");
            } else sb1.append(joiner);
        }
        sb1.append("}");
        return sb1.toString();
    }
}
