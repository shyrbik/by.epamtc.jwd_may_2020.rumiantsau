package by.it.busel.jd01_07;

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

    Matrix(String strMatrix) {
        Pattern patternToRows = Pattern.compile("[{][0-9,]+[}]");
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
