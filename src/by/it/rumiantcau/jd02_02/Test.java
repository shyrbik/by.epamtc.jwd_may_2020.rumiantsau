package by.it.rumiantcau.jd02_02;

class Test {
    public static void main(String[] args) {
        int n = 33, s = 0;

        while (n > 0)
        {
            s+= n % 2;
            n /= 2;
            System.out.println("s = " + s + "n = " + n);
        }
        System.out.println(1/2);
    }

        }
