package by.it.borodachev.jd01_05;

public class TaskA {
    /**
     *
     */
    public static void main(String[] args) {
        System.out.println("z="+step1(0.3,756.13));
        System.out.println("y="+step2(1.21,0.371));
        step3();
    }

    private static void step3() {
        double ret;
        double x=12.1;
        for (double a = -5; a <=12 ; a+=3.75) {
            ret=Math.exp(a*x)-3.45*a;
            System.out.printf("%-1s[%-5.2f]=%-50.20f%n", "f",a,ret);
        }
    }

    private static double step2(double a,double b) {
        double ret;
        ret=Math.tan(Math.pow(a+b,2))-Math.pow(a+1.5,1.0/3.0)+a*Math.pow(b,5)-b/Math.log(a*a);
        return ret;
    }

    private static double step1(double x,double z) {
        double ret = Math.cos(Math.pow(x*x+Math.PI/6.0,5))-Math.sqrt(x*Math.pow(z,3))-Math.log(Math.abs((z-1.12*x)/4));
        return ret;
        }
    }

