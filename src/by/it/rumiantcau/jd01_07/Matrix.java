package by.it.rumiantcau.jd01_07;

    class Matrix extends Var {
    private double[][] value;

    Matrix(double[ ][ ] value){
        this.value = value;
    }
    Matrix(Matrix matrix){
        this.value = matrix.value;
    }


    public String toString() {
        StringBuilder sb=new StringBuilder("{{");

        for (int i = 0; i < value.length; i++) {
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {

                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            if (i<value.length-1) sb.append("}, {");

        }
        sb.append("}}");

        return sb.toString();
        }






}
