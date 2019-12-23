package by.it.borodachev.jd01_05;

public class TaskB {
    public static void main(String[] args) {
       step1(2);
       step2();
    }

    private static void step2() {
         double a,b;
        for (double x = -5.5; x <2 ; x+=0.5) {
            if ((x<=-2) && (x>-4)) {
                b=Math.sin(x*x);
                a=Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2=%-5.2f a =%-50.30f%n",x/2.0,a);
            }
            else
             if ((x>-2) && (x<0.4)) {b= Math.cos(x*x); a=Math.log10(Math.abs(b+2.74));
                 System.out.printf("При x/2=%-5.2f a =%-50.30f%n",x/2.0,a);}
             else
              if (x==0.4) {b=1.0/Math.tan(x*x); a=Math.log10(Math.abs(b+2.74));
                 System.out.printf("При x/2=%-5.2f a =%-50.30f%n",x/2.0,a);}
              else
              {  System.out.printf( "При x/2=%-5.2f вычисления не определены%n",x/2.0);}

        }

    }

    private static double getBetta(double b) {

       return 0;
    }

    private static void step1(double x) {

        for (double a = 0; a <=2 ; a+=0.2) {
            double ret=0;
            for (int i = 1; i <=6 ; i++) {
              ret+=(Math.pow(7,a)-Math.cos(i));
           }
            System.out.printf("При a=%-5.2f Сумма y =%-50.20f%n", a,ret);
        }
     }
}
