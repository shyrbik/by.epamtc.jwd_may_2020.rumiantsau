package by.it.busel.jd01_05;

public class TaskB {
    public static void main(String[] args) {

        /*
         *  TaskB1 or "Контрольное задание №4"
         */

        for (double a1 = 0; a1 <= 2; a1 += 0.2) {
            double y1 = 0;
            for (int x1 = 0; x1 <= 6; x1++) {
                y1 = y1 + Math.pow(7, a1) - Math.cos(x1);
            }
            System.out.printf("При a=%f Сумма y = %f%n", a1, y1);
        }

        /*
         * TaskB2 or "Контрольное задание №5"
         */
        double alpha = 0;
        String chi = "При x/2=";
        String a = " a = ";
        for (double x = -5.5; x < 2; x += 0.5) {
            double vita = 0;
            if (x / 2 > -2 && x / 2 <= -1) {
                vita = Math.sin(Math.pow(x, 2));
            } else if ((x / 2) > -1 && (x / 2) < 0.2) {
                vita = Math.cos(Math.pow(x, 2));
            } else if (x / 2 == 0.2) {
                vita = 1 / Math.tan(Math.pow(x, 2));
            } else {
//                System.out.printf("При x/2=%f the calculation of alpha has not been executed" +
//                        "due to the lack of beta(vita)%n", x/2);
                System.out.printf("При x/2=%f  вычисления не определены%n", x/2);
                continue;
            }
            alpha = Math.log10(Math.abs(vita + 2.74));
            System.out.printf("При x/2=%f a = %f%n", x/2, alpha);
        }

    }
}
