package by.it.Plugatar.jd01_03;

//import java.util.Arrays;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //double[] result=InOut.getArray("1 2 3 6 7 8 9 0 11");
       // System.out.println(Arrays.toString(result));
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        double[] array=InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
       // InOut.printArray(result,"R",4);
        Helper.findMax(array);
        Helper.findMin(array);
        Helper.sort(array);
    }
}
