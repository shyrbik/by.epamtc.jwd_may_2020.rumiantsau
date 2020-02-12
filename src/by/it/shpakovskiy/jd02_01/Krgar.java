package by.it.shpakovskiy.jd02_01;

public class Krgar {
    static int i=0;
    public static void main(String[] args) {
//        boolean b=false;
//        do if (b=isB()) {
//            System.out.println("OK");
//            break;
//        }while (!b);
        for (;;){
            if (isB()){
                System.out.println("OK");
                break;
            }
            System.out.println("FAIL");
        }
    }

    private static boolean isB() {
        return ++i > 15;
    }

}
