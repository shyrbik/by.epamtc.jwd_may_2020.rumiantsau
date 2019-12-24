package by.it.plugatar.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
        if (arr.length==0) {
            return Double.MIN_VALUE;
        }
        else {double min = arr[0];
            for (double m:arr) {
                if (m<min) min=m;
            }
            return min;
        }
    }

    static double findMax(double[ ] arr) {
    if (arr.length==0) {
      return Double.MAX_VALUE;
    }
    else {double max = arr[0];
        for (double m:arr) {
            if (m>max) max=m;
            }
        return max;
        }
    }
    /** Документация бла бла бла
    * @param arr входной массив
    * @return массив по возрастанию
    */
    public static double[] sort(double[] arr) {
        for (int i = 0; i <arr.length-1 ; i++)
            for (int j = i+1; j <arr.length ; j++)
            if (arr[i]>arr[j])
            {
                double m=arr[i];
                arr[i]=arr[j];
                arr[j]=m;
            }
        return arr;
    }
    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                res[i] += matrix[i][j] * vector[j];
            }
        return res;
    }
}
