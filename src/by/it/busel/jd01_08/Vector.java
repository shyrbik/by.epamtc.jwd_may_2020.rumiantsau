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

    public static void main(String[] args) {
        Vector vectorConArr = new Vector(new double[]{1, 2, 4});
        System.out.println(vectorConArr.toString());
        Vector vectorConVec = new Vector(vectorConArr);
        System.out.println(vectorConVec.toString());
        Vector vectorConStr = new Vector("{1, 2, 4}");
        System.out.println(vectorConStr.toString());
    }
}
