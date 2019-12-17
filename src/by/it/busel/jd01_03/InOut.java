package by.it.busel.jd01_03;

/**
 * Purposes:
 * 1) to make up a "double[] array" from a "String line";
 * 2) to print out a "double[] array" in the console using a overloaded method;
 */
class InOut {
    /**
     * a method that receives a String-object, which contains doubles split with " ",
     * than trims extra " " chars, and makes up an array of doubles using a static method "parseDouble()" of
     * Object "Double" ;
     *
     * @param line a String-object, which contains doubles split with " ";
     * @return an array of primitive data-types (doubles);
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] strArrLine = line.split(" ");
        double[] doublesFromMethodGetArray = new double[strArrLine.length];
        for (int i = 0; i < strArrLine.length; i++) {
            doublesFromMethodGetArray[i] = Double.parseDouble(strArrLine[i]);
        }
        return doublesFromMethodGetArray;
    }

    /**
     * a method that receives a 1-dimensional array of primitive data-type (double),
     * prints each element of an aforementioned array separating with " " with the use of
     * the method "print()" of the object "PrintStream (java.io)"
     *
     * @param arr a 1-dimensional array of primitive data-type (double), which is to be printed;
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * a method that receives a 1-dimensional array of primitive data-type (double),
     * prints each element of an aforementioned array separating with " " with the use of
     * the method "print()" of the object "PrintStream (java.io)"
     *
     * @param arr         a 1-dimensional array of primitive data-type (double), which is to be printed;
     * @param name        a name of a aforementioned array;
     * @param columnCount a number of columns when the process of printing begins from a new row (line);
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(name + "[%d] = %.1f; ", i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
    }
}
