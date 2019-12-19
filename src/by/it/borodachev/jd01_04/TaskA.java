package by.it.borodachev.jd01_04;


import java.util.Scanner;

public class TaskA {
    public static void main(String[ ] args)
    {
        printMulTable();
        Scanner inp = new Scanner(System.in);
        String line=inp.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, (i * j));
            }
            System.out.printf("%n");
        }
    }

       static void buildOneDimArray(String line) {
        double[] mas=InOut.getArray(line);
        double minValue,maxValue;
        InOut.printArray(mas, "V", 5);
        minValue=mas[0];
        maxValue=mas[mas.length-1];
        InOut.sort(mas);
        InOut.printArray(mas, "V", 4);
           for (int i = 0; i < mas.length; i++) {
               if (mas[i]==minValue ) {System.out.println("Index of first element="+i);
                   i=mas.length;}
           }
           for (int i = 0; i < mas.length; i++) {
               if (mas[i]==maxValue ) {System.out.println("Index of last element="+i);
                   i=mas.length;}
           }
    }


}

