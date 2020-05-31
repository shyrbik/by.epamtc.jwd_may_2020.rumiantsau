package taskepam01_01;

public class Task6 {
    public static void main(String[] args) {
        double a1 =-1, d = -10;
        int n = 100;
        double an;
        System.out.println("Sn is out of range of INT type while n ="
                + valueNforOutOfRange(a1, d, n, Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println("Sn is out of range of LONG type while n ="
                + valueNforOutOfRange(a1, d, n, Long.MAX_VALUE, Long.MIN_VALUE));
    }

    private static int valueNforOutOfRange(double a1, double d, int n, double max, double min) {
        double an;
        double sum = 0;
        if (d > 0)
            while (sum < max) {
                an = a1 + (n - 1) * d;
                sum = (a1 + an) * n / 2;
                n += 10000;
            }
        else
            while (sum > min) {
                an = a1 + (n - 1) * d;
                sum = (a1 + an) * n / 2;
                n += 10000;
            }
        return n;
    }

}
