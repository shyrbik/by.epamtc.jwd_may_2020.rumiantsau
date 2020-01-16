package by.it.popkov.jd01_07;

class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(7);
        Var var2 = new Scalar(scalar);
        Object var3 = new Scalar("123.456");
        System.out.println(scalar);
        System.out.println(var2.toString());
        System.out.println(var3);
        System.out.println();



        Vector vector = new Vector(new double[]{1.0, 2.0, 3.0});
        Var vector2 = new Vector(vector);
        Var vector3 = new Vector("{1,2,4}");
        System.out.println(vector);
        System.out.println(vector2);
        System.out.println(vector3);

        System.out.println();
        Matrix matrix = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Var matrix2 = new Matrix(matrix);
        Object matrix3 = new Matrix("{{1,2},{3,4}}");
        System.out.println(matrix);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
