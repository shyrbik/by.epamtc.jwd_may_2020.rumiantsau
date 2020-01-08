package by.it.kuzmichalex.jd01_07;

class Vector extends Var {
    double[] value;

    /**
     * construct from double[]
     */
    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    /**
     * construct from Vector
     */
    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    /**
     * construct from string like {1.234, 5.678}
     */
    Vector(String strValue) {
        String[] strElements = strValue.replaceAll("[\\\\{|\\\\}| ]", " ").split(",");
        this.value = new double[strElements.length];
        for (int i = 0; i < strElements.length; i++) {
            this.value[i] = Double.parseDouble(strElements[i]);
        }
    }
    /**
     * converts Vector to String
     * */
    @Override
    public String toString() {
        StringBuffer returnStrBuffer = new StringBuffer("{");
        for (int i = 0; i < this.value.length; i++) {
            returnStrBuffer.append(Double.toString(this.value[i]));
            if (i < (this.value.length - 1)) returnStrBuffer.append(", ");
        }
        returnStrBuffer.append("}");
        return returnStrBuffer.toString();
    }
}
