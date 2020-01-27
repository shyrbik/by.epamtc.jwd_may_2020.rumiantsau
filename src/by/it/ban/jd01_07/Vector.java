package by.it.ban.jd01_07;

public class Vector extends Var{
    public double[] value;
    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);

    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value,0,this.value,0,vector.value.length);
    }

    public Vector(String strVector) {
        String[] vectorStr = strVector.trim().substring(1,strVector.length()-1).split(",");
        this.value = new double[vectorStr.length];
        for (int i = 0; i < vectorStr.length; i++) {
            this.value[i]=Double.parseDouble(vectorStr[i]);
        }


    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{");
        String delimiter = "";
        for (double element : value) {
            res.append(delimiter).append(element);
            delimiter = ", ";
        }
        res.append("}");
        return res.toString();
    }
}
