package by.it.shpakovskiy.jd01_07;

class Runner {
    public static void main(String[] args) {
        Var var=new Scalar("3.968");
        System.out.println(var.toString());
        Var var1=new Vector("1.5, 2.65, 3.93");
        System.out.println(var1.toString());
        Var var2=new Matrix("{{1.5,2.67},{3.05,8.12}}");
        System.out.println(var2.toString());
    }
}
