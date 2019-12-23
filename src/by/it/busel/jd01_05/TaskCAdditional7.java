package by.it.busel.jd01_05;

import java.util.Arrays;
import java.lang.Math;

public class TaskCAdditional7 {
    public static void main(String[] args) {
        /*
         * TaskC2 or "Контрольное задание №7"
         */

        double[] a = new double[31];
        arrayFillerA(a);
        double[] b = new double[counter(a)];
        arrayFillerB(a, b);
        Arrays.sort(b);
        printArrayA(a, "M", 5);
        printArrayB(b, "B");
    }

    /**
     * @param arrayB an array to print;
     * @param name   a name of an array to print;
     */
    private static void printArrayB(double[] arrayB, String name) {
        double[][] bMod = new double[7][(int) Math.ceil(arrayB.length / 7.0)];
        arrayFillerBMod(arrayB, bMod);
        printArrayBMod(bMod, name, arrayB);

    }

    /**
     * An auxiliary method that helps a method "printArrayB(double[] arrayB, String name)" to print "arrayB";
     *
     * @param arrayBMod a temporary array created for the sake of printing an array "arrayB";
     * @param name      a name of an array to print
     * @param arrayB    an initial arrays  which elements are to be printed;
     */
    private static void printArrayBMod(double[][] arrayBMod, String name, double[] arrayB) {
        System.out.printf("Massiv %s[] <index to cols>%n", name);
        int rmd = arrayB.length % 7;
        if (arrayBMod[0].length > 1) {
            System.out.print("╔═════════════");
            for (int i = 0; i < arrayBMod[0].length - 1 - 1; i++) {
                System.out.print("╦═════════════");
            }
            System.out.println("╦═════════════╗");
        } else if (arrayBMod[0].length == 1) {
            System.out.println("╔═════════════╗");
        }

        for (int i = 0; i < arrayBMod.length; i++) {
            int delta = 0;
            for (int j = 0; j < arrayBMod[0].length; j++) {
                int index = i + delta;
                if (index < arrayB.length) {
                    System.out.printf("║ " + name + "[%2d]=%.1f ", index + 1, arrayBMod[i][j]);
                    delta += 7;
                    if (j == arrayBMod[0].length - 1 && i != arrayBMod.length - 1) {
                        System.out.println("║");

                        if (arrayBMod[0].length > 1) {
                            System.out.print("╠═════════════");
                            for (int z = 0; z < arrayBMod[0].length - 1 - 1; z++) {
                                System.out.print("╬═════════════");
                            }
                            System.out.println("╬═════════════╣");
                        } else if (arrayBMod[0].length == 1) {
                            System.out.println("╠═════════════╣");
                        }
                    } else if (j == arrayBMod[0].length - 1) {
                        System.out.println("║");
                    }
                }
                if (rmd != 0 && i >= rmd && index >= arrayB.length && i != arrayBMod.length - 1) {
                    System.out.println("║             ║");
                    if (arrayBMod[0].length > 1) {
                        System.out.print("╠═════════════");
                        for (int z = 0; z < arrayBMod[0].length - 1 - 1; z++) {
                            System.out.print("╬═════════════");
                        }
                        System.out.println("╬═════════════╣");
                    } else if (arrayBMod[0].length == 1) {
                        System.out.println("╠═════════════╣");
                    }
                } else if (rmd != 0 && i >= rmd && index >= arrayB.length) {
                    System.out.println("║             ║");
                }
            }
        }
        if (arrayBMod[0].length > 1) {
            System.out.print("╚═════════════");
            for (int i = 0; i < arrayBMod[0].length - 1 - 1; i++) {
                System.out.print("╩═════════════");
            }
            System.out.println("╩═════════════╝");
        } else if (arrayBMod[0].length == 1) {
            System.out.println("╚═════════════╝");
        }
    }

    /**
     * An auxiliary method that fills a temporary array which elements are being printed;
     *
     * @param originalArrayB  an initial array;
     * @param targetArrayBMod a temporary array which elements are being printed;
     */
    private static void arrayFillerBMod(double[] originalArrayB, double[][] targetArrayBMod) {
        for (int i = 0; i < targetArrayBMod.length; i++) {
            int delta = 0;
            for (int j = 0; j < targetArrayBMod[0].length; j++) {
                int index = i + delta;
                if (index < originalArrayB.length) {
                    targetArrayBMod[i][j] = originalArrayB[index];
                    delta += 7;
                }
            }
        }

    }

    /**
     * A method, which fills an array "b" with the numbers from an array "a" that coincide with a statement of TaskC2:
     * "10% of originalArrayA[i]" should be more than "i";
     *
     * @param originalArrayA an initial array;
     * @param targetArrayB   an array that is being build;
     */
    private static void arrayFillerB(double[] originalArrayA, double[] targetArrayB) {
        int indexOfTargetArrayB = 0;
        for (int i = 0; i < originalArrayA.length; i++) {
            if (originalArrayA[i] * 0.1 > i) {
                targetArrayB[indexOfTargetArrayB] = originalArrayA[i];
                indexOfTargetArrayB++;
            }
        }
    }


    /**
     * A method that finds dimensions of an array "b" according to the statement of TaskC2;
     *
     * @param array an original array which numbers are to be copied to an array "b";
     * @return length of an array of "b";
     */
    private static int counter(double[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * A method that fills an array "a" with integral numbers between 103 and 450 including 103 and 450
     * according to the statement of TaskC2;
     *
     * @param array an array, which is to be filled with aforementioned integral numbers;
     */
    private static void arrayFillerA(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generator();
        }
    }

    /**
     * A method that generates pseudorandom integral numbers from the following range: [103, 450]
     *
     * @return a pseudorandom integral number from an aforementioned range;
     */
    private static double generator() {
        return (int) (Math.random() * (347 + 1)) + 103.0;
    }

    private static void printArrayA(double[] array, String name, int columnNumber) {
        System.out.printf("Massiv %s[] <index to rows>%n", name);
//        System.out.printf("Массив %s[] <index to cols>%n", name);
        System.out.print("╔═════════════╦═════════════╦═════════════╦═════════════╦═════════════╗\n");
        for (int x = 0; x < array.length; x++) {
            System.out.printf("║ " + name + "[%2d]=%.1f ", x + 1, array[x]);
            if ((x + 1) % columnNumber == 0) {
                System.out.println("║");
                System.out.println("╠═════════════╬═════════════╬═════════════╬═════════════╬═════════════╣");
            } else if (x == array.length - 1) {
                int rem = (x + 1) % columnNumber;
                if (rem == 1) {
                    System.out.println("║             ║             ║             ║             ║");
                }
                System.out.println("╚═════════════╩═════════════╩═════════════╩═════════════╩═════════════╝");
            }
        }
    }
}
