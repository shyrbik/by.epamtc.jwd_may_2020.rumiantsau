package by.it.filipovich.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        functionSix();

    }

    private static void functionSix() {
        double leftOfX = 5.33;
        double rightOfX = 9;
        double delta = 0.12;
        int  sizeOfArray = (int) ((rightOfX-leftOfX)/delta);
        double[] array1 = new double[sizeOfArray+1];
        int indOfArray = 0;
        double x = leftOfX;

        while(indOfArray < array1.length && x <= rightOfX){
                array1[indOfArray] = methodZ(x);
                x = x + delta;
                indOfArray++;
        }
            printArray(array1,"M",5);
        }




    private static double methodZ(double x) {
        return cbrt(x*x + 4.5);
    }

    public static void printArray(double[] result, String name, int columnCount) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf(name+"[%-2d]=%-6.2f", i+1, result[i]);
            if((i+1)%columnCount == 0)
                System.out.println();
        }
    }

}
