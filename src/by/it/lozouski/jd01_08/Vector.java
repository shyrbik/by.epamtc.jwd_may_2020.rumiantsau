package by.it.lozouski.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector(String strVector) {
        String[] temp = strVector.replaceAll("[{}]", "").split(",");
        this.value = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            value[i] = Double.parseDouble(temp[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Scalar) other).getValue();
            }
            return new Vector(sum);
        }
        if (other instanceof Vector) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Vector) other).value[i];
            }
            return new Vector(sum);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] - ((Scalar) other).getValue();
            }
            return new Vector(sum);
        }
        if (other instanceof Vector) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] - ((Vector) other).value[i];
            }
            return new Vector(sum);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] = mul[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        if (other instanceof Vector) {
            double[] mul = Arrays.copyOf(value, value.length);
            double scalarMultipleVectors = 0;
            for (int i = 0; i < mul.length; i++) {
                scalarMultipleVectors = scalarMultipleVectors + mul[i] * ((Vector) other).value[i];
            }
            return new Scalar(scalarMultipleVectors);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (double elem : value) {
            sb1.append(joiner).append(elem);
            joiner = ", ";
        }
        sb1.append("}");
        return sb1.toString();
    }
}
