package by.it.busel.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(strVector);
        int counter = counterOfValueLength(matcher);
        if (counter > 0) {
            valueFiller(matcher, counter);
        }
    }

    @Override
    public String toString() {
        String sep = ", ";
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i != value.length - 1) {
                sb.append(sep);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        try {
            return this.add((Scalar) other);
        } catch (ClassCastException e) {
            try {
                return this.add((Vector) other);
            } catch (ClassCastException e1) {
                return super.add(other);
            }
        }
    }

    public Var add(Scalar other) {
        double[] result = new double[this.value.length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = this.value[i] + filler;
        }
        return new Vector(result);
    }

    public Var add(Vector other) {
        if (this.value.length == other.value.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < value.length; i++) {
                result[i] = this.value[i] + other.value[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e) {
            try {
                return this.sub((Vector) other);

            } catch (ClassCastException e1) {
                return super.sub(other);
            }
        }
    }

    private Var sub(Scalar other) {
        double[] result = new double[this.value.length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = this.value[i] - filler;
        }
        return new Vector(result);
    }

    private Var sub(Vector other) {
        if (this.value.length == other.value.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < value.length; i++) {
                result[i] = this.value[i] - other.value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e) {
            try {
                return this.mul((Vector) other);
            } catch (ClassCastException e1) {
                return super.mul(other);
            }
        }
    }

    private Var mul(Scalar other) {
        double[] result = new double[this.value.length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = this.value[i] * filler;
        }
        return new Vector(result);
    }

    private Var mul(Vector other) {
        if (this.value.length == other.value.length) {
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result = result + this.value[i] * other.value[i];
            }
            return new Scalar(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e) {
            return super.div(other);
        }
    }

    private Var div(Scalar other) {
        double filler = other.getValue();
        if (filler != 0) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] / filler;
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    private void valueFiller(Matcher matcher, int counter) {
        value = new double[counter];
        int indexValueArray = 0;
        while (matcher.find()) {
            value[indexValueArray++] = Double.parseDouble(matcher.group());
        }
        matcher.reset();
    }

    private int counterOfValueLength(Matcher matcher) {
        if (!matcher.find()) {
            return 0;
        }
        matcher.reset();
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        matcher.reset();
        return counter;

    }

    public static void main(String[] args) {
        Vector vectorConArr = new Vector(new double[]{1, 2, 4});
        System.out.println(vectorConArr.toString());
        Vector vectorConVec = new Vector(vectorConArr);
        System.out.println(vectorConVec.toString());
        Vector vectorConStr = new Vector("{1, 2, 4}");
        System.out.println(vectorConStr.toString());
    }
}
