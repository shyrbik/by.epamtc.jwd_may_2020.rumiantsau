package by.it.busel.jd01_04;

/**
 * Purposes:
 *
 * 1) to make up a "double[] array" from a "String line";
 * 2) to print out a "double[] array" in the console;
 *
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
        String[] lineStringArray = line.split(" ");
        double[] lineDoubleArray = new double[lineStringArray.length];
        for (int i = 0; i < lineStringArray.length; i++) {
            lineDoubleArray[i] = Double.parseDouble(lineStringArray[i]);
        }
        return lineDoubleArray;
    }

    /**
     * a method that receives a 1-dimensional array of primitive data-type (double),
     * prints each element of an aforementioned array separating with " " with the use of
     * the method "printF()" of the object "PrintStream (java.io)"
     * @param arrayOfDoubles a 1-dimensional array of primitive data-type (double), which is to be printed;
     * @param name a name of a aforementioned array;
     * @param columnNumber a number of columns when the process of printing begins from a new row (line);
     */
    static void printArray(double[] arrayOfDoubles, String name, int columnNumber) {
        for (int x = 0; x < arrayOfDoubles.length; x++) {
            System.out.printf(name + "[% -3d]=%.3f ", x, arrayOfDoubles[x]);
            if ((x+1) % columnNumber == 0 || x == arrayOfDoubles.length - 1) {
                System.out.println();
            }
        }
    }
}
