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

    }
}
