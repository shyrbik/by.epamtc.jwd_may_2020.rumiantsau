package by.it.kuzmichaa.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1(){
        for (double a=0; a<=2; a=a+0.2){
            double b = 0;
            for (double i = 1; i <=6 ; i++) {
                b += Math.pow(7, a) - Math.cos(i);
            }

            System.out.printf("При a=%3.2f Сумма y = %g\n", a, b);
        }
    }
    private static void step2(){
        double b = 0;
        for (double x = -5.5; x < 2; x=x+0.5) {
            if (x/2>-2 & x/2<=-1){
                b=Math.sin(x*x);
                double a = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2 = %4.2f Значение a = %g\n", x/2, a);
            }
            else if (x/2>-1 & x/2<0.2){
                b=Math.cos(x*x);
                double a = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2 = %4.2f Значение a = %g\n", x/2, a);
            }
            else if (x/2==0.2){
                b=1/Math.tan(x*x);
                double a = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2 = %4.2f Значение a = %g\n", x/2, a);
            }
            else {
                System.out.printf("При x/2 = %4.2f Вычисления не определены\n", x/2);
            }
        }


    }
}
