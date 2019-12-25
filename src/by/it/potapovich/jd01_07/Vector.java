package by.it.potapovich.jd01_07;

import java.util.Arrays;

class Vector extends Var{
     private double [] value;


      Vector(double[] value) {
         this.value = value;
     }
     Vector (Vector vector) {
          this.value = vector.value;
     }
     Vector (String strVector){
          strVector = strVector.replaceAll("[{}]", "");
          String [] strVectors = strVector.split(",");
          double [] doubleVector = new double[strVectors.length];
         for (int i = 0; i < strVectors.length; i++) {
             doubleVector [i]= Double.parseDouble(strVectors[i]);
         }
          this.value = doubleVector;

         }



    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder("{");
         String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
            
        }
        sb.append("}");
        return sb.toString();
    }
}
