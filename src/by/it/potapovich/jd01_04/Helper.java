package by.it.potapovich.jd01_04;

public class Helper {
    static double findMin(double[] arr) {


        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double v : arr) {


                if (min > v) {
                    min = v;
                }
              //  return min;


            }
            return min;
        }
    }
    static double findMax(double[ ] mas){
        if (0==mas.length){
            return Double.MAX_VALUE;
        }else {
            double max = mas [0];
            for (double element : mas) {
                if (max < element) {
                    max = element;
                }
                }
        return max;
        }

    }
    static void sort(double[ ] arrays){
        boolean upDirection = true;
        for (int i = 0; i < arrays.length-1; i++) {
            for (int j = i+1; j < arrays.length; j++) {
              if ((upDirection && arrays[i] > arrays[j]|| (!upDirection&&arrays[i]<arrays[j])))
                {
                double m=arrays [i];
               arrays [i] = arrays [j];
               arrays [j] = m;
                  System.out.println(arrays [i]);

              }

                }
                
            }

        }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[]z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i]= z[i] + matrix [i][j] * vector [j];
                
            }
            
        }

return z;

    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][]f = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    f[i][j]=f[i][j] + matrixLeft [i][k] * matrixRight[k][j];
                }
                
            }
            
        }
        return f;

    }


    }

