package by.it.filipovich.jd01_08;

public class Matrix extends Var {

    protected double[][] value;

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

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j]+((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        if(other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length &&
                    this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] sum = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sum.length; i++) {
                    for (int j = 0; j < sum[0].length; j++) {
                        sum[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        if(other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length &&
                    this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] sum = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sum.length; i++) {
                    for (int j = 0; j < sum[0].length; j++) {
                        sum[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
