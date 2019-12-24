package by.it.akhmelev.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar scalar = new Scalar(7);
        Var var2 = new Scalar(scalar);
        Var var3 = new Scalar("123.456");
        System.out.println(scalar);
        System.out.println(var2);
        System.out.println(var3);

        Var vec = new Vector(new double[]{1, 2, 3, 4});
        System.out.println(vec);
    }
}
