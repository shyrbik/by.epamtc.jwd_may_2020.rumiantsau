package by.it.shpakovskiy.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    static void sort(double[] arr) {
        int k=arr.length/2;
        while (k > 0) {
            for (int i=0;i<arr.length-k;i++){
                int j=i;
                while (j>=0 && arr[j]>arr[j+k]){
                    double buf=arr[j];
                    arr[j]=arr[j+k];
                    arr[j+k]=buf;
                    j--;
                }
            }
            k=k/2;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]+=matrix[i][j]*vector[j];
            }
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
