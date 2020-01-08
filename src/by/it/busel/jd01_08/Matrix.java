package by.it.busel.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public Var add(Var other) {
        try {
            return this.add((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.add((Matrix) other);
            } catch (ClassCastException e1) {
                return super.add(other);
            }
        }
    }

    private Var add(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] + filler;
            }
        }
        return new Matrix(result);
    }

    private Var add(Matrix other) {
        if (this.value.length == other.value.length &&
                this.value[0].length == other.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + other.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.sub((Matrix) other);
            } catch (ClassCastException e1) {
                return super.sub(other);
            }
        }
    }

    private Var sub(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] - filler;
            }
        }
        return new Matrix(result);
    }

    private Var sub(Matrix other) {
        if (this.value.length == other.value.length &&
                this.value[0].length == other.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - other.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.mul((Vector) other);
            } catch (ClassCastException e1) {
                try {
                    return this.mul((Matrix) other);
                } catch (ClassCastException e2) {
                    return super.mul(other);
                }
            }
        }
    }

    private Var mul(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] * filler;
            }
        }
        return new Matrix(result);
    }

    private Var mul(Vector other) {
        double[] vector = other.getValue();
        if (this.value[0].length == vector.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i] = result[i] + this.value[i][j] * vector[j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    private Var mul(Matrix other) {
        if (this.value[0].length == other.value.length) {
            double[][] result = new double[this.value.length][other.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < this.value[0].length; k++) {
                        result[i][j] = result[i][j] + this.value[i][k] * other.value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e0) {
            return super.div(other);
        }
    }

    private Var div(Scalar other) {
        double filler = other.getValue();
        if (filler != 0) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] / filler;
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    Matrix(String strMatrix) {
        Pattern patternToRows = Pattern.compile("[{][0-9, ]+[}]");
        Matcher matcherToRows = patternToRows.matcher(strMatrix);
        int numberOfRows = counterOfElementsOfAnArray(matcherToRows);
        String[] strArrayRows = concstructorArrayRows(matcherToRows, numberOfRows);

        Pattern patternRowsToElements = Pattern.compile("[0-9]+");
        Matcher matcher = patternRowsToElements.matcher(strArrayRows[0]);
        int numberOfColumns = counterOfElementsOfAnArray(matcher);
        if (numberOfRows > 0 && numberOfColumns > 0) {
            value = new double[numberOfRows][numberOfColumns];
            valueFiller(strArrayRows, matcher);
        }
    }

    private String[] concstructorArrayRows(Matcher matcherToRows, int numberOfRows) {
        String[] sb = new String[numberOfRows];
        int index = 0;
        while (matcherToRows.find()) {
            sb[index++] = matcherToRows.group();
        }
        matcherToRows.reset();
        return sb;
    }

    private int counterOfElementsOfAnArray(Matcher matcher) {
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

    private void valueFiller(String[] strArrayRows, Matcher matcher) {
        for (int i = 0; i < strArrayRows.length; i++) {
            matcher.reset(strArrayRows[i]);
            int indexInsideRow = 0;
            while (matcher.find()) {
                value[i][indexInsideRow++] = Double.parseDouble(matcher.group());
            }
        }
    }

    @Override
    public String toString() {
        String separator = ", ";
        StringBuilder strToString = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            strToString.append("{");
            for (int j = 0; j < value[0].length; j++) {
                strToString.append(value[i][j]);
                if (j != value[0].length - 1) {
                    strToString.append(separator);
                }
            }
            strToString.append("}");
            if (i != value.length - 1) {
                strToString.append(separator);
            }
        }
        strToString.append("}");
        return strToString.toString();
    }
}
