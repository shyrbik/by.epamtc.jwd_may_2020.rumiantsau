package by.it.filipovich.jd01_07;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value){
    this.value = new double[value.length][value[0].length];

    for (int i = 0; i < value.length; i++) {
        System.arraycopy(value[i], 0, this.value[i], 0, value[0].length);
    }
    }

    public Matrix(Matrix matrix){
        this(matrix.value);
    }

    public Matrix(String strMatrix){
        String[] a = strMatrix.split("},");
        String b = a[0].replaceAll("\\D","").trim();

        double[][] arr = new double[a.length][b.length()];
        for (int i = 0; i < a.length; i++) {
            String[] mas = a[i].replaceAll("\\D"," ")
                    .replaceAll(" {2,}", " ")
                    .trim()
                    .split(" ");
            for (int j = 0; j < b.length(); j++) {
                arr[i][j] = Double.parseDouble(mas[j]);
            }
        }
        this.value = new double[arr.length][arr[0].length];
        System.arraycopy(arr, 0, this.value, 0, arr.length);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if(j != value[0].length-1)
                    sb.append(", ");
            }
            sb.append("}");
            if(i != value.length-1)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
