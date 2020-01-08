package by.it.tarasevich.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str) {
        String string = str.replaceAll("\\{", "").replaceAll("\\}","");;
        String[] s1 = string.split(",");
        Double[] doubles = new Double[s1.length];
        for (int i = 0; i < s1.length; i++) {
            doubles[i] = Double.parseDouble(s1[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String delimeter = "";
        for (double element : value) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

