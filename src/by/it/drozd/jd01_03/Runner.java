package by.it.drozd.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        double[][] firstMass={ {1,2,3} ,{4,5,6},{7,8,9} };
        double[][] secondMass={ {1,2,3} ,{4,5,6},{7,8,9} };

        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        double[] array=InOut.getArray(str);

        InOut.printArray(array);
        InOut.printArray(array,"V",3);

        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

        Helper.mul(firstMass,array);
        Helper.mul(firstMass,secondMass);
    }
}
