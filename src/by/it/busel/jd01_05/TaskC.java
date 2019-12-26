package by.it.busel.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        /*
         * TaskC1 or "Контрольное задание №6"
         */

        double[] a = new double[28], b;
        arrayFillerA(a);
        b = new double[counter3dot5(a)];
        arrayFillerB(a, b);
        double amv = arithmeticMeanValueArrayB(b);
        printArray(a, "A", 5, 0);
        printArray(b, "B", 5, 1);

    }

    /**
     * A method that calculates an arithmetic mean value of the input array;
     *
     * @param arrayB an array of doubles;
     * @return an arithmetic mean value of all numbers of a aforementioned array;
     */
    private static double arithmeticMeanValueArrayB(double[] arrayB) {
        double sum = 0;
        for (double v : arrayB) {
            sum = sum + v;
        }
        return sum / arrayB.length;
    }

    /**
     * A method that fills a target-array with numbers from an original array that are more than 3.5;
     *
     * @param originalArrayA an array which contains numbers that are more than 3.5 and that are be copied to a target-array;
     * @param TargetArrayB   an array, which is to be filled with numbers that are more than 3.5;
     */
    private static void arrayFillerB(double[] originalArrayA, double[] TargetArrayB) {
        int indexWithinArrayB = 0;
        for (double v : originalArrayA) {
            if (v > 3.5) {
                TargetArrayB[indexWithinArrayB++] = v;
            }
        }
    }

    /**
     * A method that finds dimensions of an array "b";
     *
     * @param arrayA an array which will be looked though in order to find numbers that are more than 3.5;
     * @return a length of an array "b";
     */
    private static int counter3dot5(double[] arrayA) {
        int counter = 0;
        for (double v : arrayA) {
            if (v > 3.5) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * A method, which fills an array "a" according to a statement of a problem;
     *
     * @param arrayA an array that is to be filled according to a statement of a problem;
     */
    private static void arrayFillerA(double[] arrayA) {
        int index = 0;
        for (double z = 5.33; z <= 9; z = z + 0.131071428571428571) {
            arrayA[index++] = Math.cbrt((Math.pow(z, 2) + 4.5));
        }
    }

    /**
     * A method that generates pseudorandom real numbers in the following range: [5.33, 9]
     *
     * @return a pseudorandom real number with 15 digits after a comma (a dot)
     * in the following range: [5.33, 9);
     */
    private static double generatorX() {
        return Math.round((Math.random() * 3.67) * 1000000000000000.00) / 1000000000000000.00 + 5.33;
        // range [5.33, 9):
        // return Math.random() * 3.67 + 5.33;
    }

    /**
     * a method that receives a 1-dimensional array of primitive data-type (double),
     * prints each element of an aforementioned array separating with " " with the use of
     * the method "printF()" of the object "PrintStream (java.io)"
     *
     * @param array        a 1-dimensional array of primitive data-type (double), which is to be printed;
     * @param name         a name of a aforementioned array;
     * @param columnNumber a number of columns when the process of printing begins from a new row (line);
     * @param sign0or1     if you enter "0" the method prints the array "a" from TaskC1; if you enter "1" - the array "b"
     */
    private static void printArray(double[] array, String name, int columnNumber, int sign0or1) {
        if (sign0or1 == 0) {
            System.out.printf("Массив %s[]%n", name);
        } else if (sign0or1 == 1) {
            System.out.printf("Массив %s[] из элементов массива A > 3.5%n", name);
        } else {
            System.out.println("Просьба вызвать метод заного, введя в его аргумент \"0\" или \"1\"");
            return;
        }
        for (int x = 0; x < array.length; x++) {
            System.out.printf(name + "[% -3d] = %.5f ", x, array[x]);
            if ((x + 1) % columnNumber == 0 || x == array.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
