package by.it.potapovich.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    //Matrix(String strMatrix) {
       // this.value = new double[][]{Double.parseDouble(strMatrix)};
    }

   // @Override
   // public String toString() {
    //    StringBuilder sb1 = new StringBuilder("{ ");
    ///    String delimiter = "{";
    //    String secondDelimiter = "";
     //   for (double[] element : value) {

            // }
            // sb1.append()

            //  return sb1.append("}");
       // }
   // }
//}
