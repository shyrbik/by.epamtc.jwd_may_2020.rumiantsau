package by.it.filipovich.jd01_05;

public class OutputArray {

    protected static void printArray(double[] result, String name, int columnCount) {

        for (int i = 0; i < result.length; i++) {
            System.out.printf(name+"[%3d]=%-8.5f", i, result[i]);
            if((i+1)%columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }

    protected static void printArray(int[] result, String name, int columnCount) {

        for (int i = 0; i < result.length; i++) {
            System.out.printf(name+"[%-2d]=%-6d", i, result[i]);
            if((i+1)%columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }

    protected static void printArray2(int[] result, String name, int stringCount) {

        for (int i = 0; i < result.length; i++) {
            System.out.printf(name+"[%-2d]=%-6d\n", i+1, result[i]);
            if((i+1)%stringCount == 0)
                System.out.println();
        }
        System.out.println();
    }

}
