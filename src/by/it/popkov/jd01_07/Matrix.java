package by.it.popkov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][matrix.value[0].length];
        System.arraycopy(matrix.value, 0, this.value, 0, matrix.value.length);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]+", "");
        strMatrix = strMatrix.replaceAll("[}]{2,}", "");
        strMatrix = strMatrix.replaceAll(",", " ");
        strMatrix = strMatrix.replaceAll("}", " }");

        Pattern p = Pattern.compile("}");
        Matcher m = p.matcher(strMatrix);
        int columnCounter = 1;
        while (m.find()) {
            columnCounter++;
        }
        Pattern p2 = Pattern.compile("[[0-9]/.?]+");
        Matcher m2 = p2.matcher(strMatrix);
        int numCounter = 0;
        while (m2.find()) {
            numCounter++;
        }
        strMatrix = strMatrix.replaceAll(" }", "");
        String[] nums = strMatrix.split(" ");
        value = new double[columnCounter][numCounter / columnCounter];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                value[i][j] = Double.parseDouble(nums[i * value[0].length + j]);
            }
        }

    }


    @Override
    public String toString() {
        StringBuilder toStr = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            toStr.append("{");
            for (int j = 0; j < value[0].length; j++) {
                if (j != value[0].length - 1) {
                    toStr.append(value[i][j]).append(", ");
                } else if (j == value[0].length - 1 && i != value.length - 1) {
                    toStr.append(value[i][j]).append("},");
                } else if (j == value[0].length - 1 && i == value.length - 1) {
                    toStr.append(value[i][j]).append("}");
                }
            }

        }
        toStr.append("}");
        return toStr.toString();
    }
}
