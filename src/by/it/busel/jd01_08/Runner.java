package by.it.busel.jd01_08;

class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1, 2, 3});
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        /*
         * Task A
         */
        print(s.add(s));
//        print(s.add(v));
//        print(s.add(m));
        print(s.sub(s));
//        print(s.sub(v));
//        print(s.sub(m));
        print(s.mul(s));
//        print(s.mul(v));
//        print(s.mul(m));
        print(s.div(s));
//        print(s.div(v));
//        print(s.div(m));


        /*
         * Task B
         */
        print(v.add(v));
        print(v.sub(v));
        print(v.mul(v));
        print(v.div(v));



    }
}
