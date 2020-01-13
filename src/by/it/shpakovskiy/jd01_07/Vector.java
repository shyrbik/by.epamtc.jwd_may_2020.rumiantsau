package by.it.shpakovskiy.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{|}]", "");
        String[] stringValue = strVector.split(",");
        value = new double[stringValue.length];
        for (int i = 0; i < stringValue.length; i++) {
            value[i] = Double.parseDouble(stringValue[i].trim());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
