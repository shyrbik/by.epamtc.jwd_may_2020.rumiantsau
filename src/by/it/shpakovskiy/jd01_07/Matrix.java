package by.it.shpakovskiy.jd01_07;

import java.util.Arrays;

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
