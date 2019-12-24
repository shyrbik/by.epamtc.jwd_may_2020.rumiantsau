package by.it.potapovich.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }


    private static void step1() {
        double a;
        double x;
        double y;



        for (a = 0; a <= 2; a= a+ 0.2) {
            //System.out.printf("a=%1.2f\n",a);
            double s = 1;
            if(s<=6){
                y= s * pow(7, a);
                s++;

            for (x=1 ; x <= y; x++) {
                // System.out.println(y);
                y = y - cos(x);
                System.out.printf("При a=%1.2f y=%g\n", a, y);

            }

        }
    }
}
    private static void step2() {
        double  x;
        double a;
        double b;
        for ( x = -5.5; x < 2; x = x + 0.5) {

            if (x/2 > -2 && x/2 <= -1) {
                b = sin(pow(x,2));
                a= log10(abs(b+2.74));
                System.out.printf("При x/2=%1.2f a=%g\n",x/2,a);

            }else if (x/2 > -1 && x/2 < 0.2) {
                b = cos(pow(x,2));
                a= log10(abs(b+2.74));
                System.out.printf("При x/2=%1.2f a=%g\n",x/2,a);
            }else if (x/2 == 0.2){
                b= 1/tan(pow(x,2));
                a= log10(abs(b+2.74));
                System.out.printf("При x/2=%1,2f a=%g\n",x/2,a);
            }
           // a= log(abs(b+2.74));
          //  System.out.println(a);
         //   System.out.println("8540");
        }
    }
}
