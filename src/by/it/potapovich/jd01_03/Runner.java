package by.it.potapovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[]array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        int n = scanner.nextInt();
        double[]arr=new double[n];
       Helper.findMin(arr);
       int v = scanner.nextInt();
       double[]mas= new double[v];
       Helper.findMax(mas);
       int r = scanner.nextInt();
       double[]arrays = new double[r];
       Helper.sort(arrays);
      int k = scanner.nextInt();
      int x = scanner.nextInt();
      double [] []matrix = new double[k][k];
      double []vector = new double[x];

      Helper.mul(matrix,vector);
      int f = scanner.nextInt();
      int s = scanner.nextInt();
      double [][]matrixLeft=new double[f][f];
      double [][] matrixRight = new double[s][s];
      Helper.mul(matrixLeft,matrixRight);



    }
}
