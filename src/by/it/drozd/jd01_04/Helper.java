package by.it.drozd.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double minValue = arr[0];
        for (double element : arr) {
            if (minValue > element) {
                minValue = element;
            }
        }
        System.out.println("min= " + minValue);
        return minValue;
    }

    static double findMax(double[] arr) {
        double maxValue = arr[0];
        for (double element : arr) {
            if (maxValue < element) {
                maxValue = element;
            }
        }
        System.out.println("max= " + maxValue);
        return maxValue;
    }

    static void sort(double[ ] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    double m=arr[i];
                    arr[i]=arr[j];
                    arr[j]=m;
                }
            }
        }
        for (double elem : arr) {
            System.out.print(elem+"  ");
        }
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] newMass=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newMass[i]+=matrix[i][j]*vector[j];
            }
        }
        for (double mass : newMass) {
            System.out.println("New Vector= "+mass);
        }

    return newMass;
    }
   static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
       double[][] newMass=new double[matrixLeft.length][matrixRight[0].length];
       for (int i = 0; i < matrixLeft.length; i++) {
           for (int j = 0; j < matrixRight[0].length; j++) {
               for (int k = 0; k < matrixRight.length; k++) {
                   newMass[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
               }
           }
           }
       for (int i = 0; i < newMass.length; i++) {
           for (int j = 0; j < newMass.length; j++) {
               System.out.print(newMass[i][j]+" ");
           }
           System.out.println();
       }
       return newMass;
    }
}
