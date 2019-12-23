package by.it.busel.jd01_05;

public class TaskA {
    public static void main(String[] args) {

        /*
         * TaskA1 or "Контрольное задание №1"
         */

        double a = 756.13;
        double x = 0.3;
        double cos = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5));
        double rt = Math.sqrt(x * Math.pow(a, 3));
        double ln = Math.log(Math.abs((a - 1.12 * x) / 4));
        double z = cos - rt - ln;
        double zFullView = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5)) - Math.sqrt(x * Math.pow(a, 3)) - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.println(z);

        /*
         * TaskA2 or "Контрольное задание №2"
         */

        a = 1.21;
        double b = 0.371;
        double tg = Math.tan(Math.pow((a + b), 2));
        double cbrt = Math.cbrt(a + 1.5);
        double mlt = a * Math.pow(b, 5);
        double dvs = b / (Math.log(Math.pow(a, 2)));
        double y = tg - cbrt + mlt - dvs;
        System.out.println(y);

        /*
         * TaskA3 or "Контрольное задание №3"
         */

        double x3 = 12.1;
        for (double a3 = -5; a3 <= 12; a3 += 3.75) {
            double f = Math.pow(Math.E, a3 * x3) - 3.45 * a3;
            System.out.printf("При a=%f Сумма y = %f3%n", a3, f);
        }

    }
}
