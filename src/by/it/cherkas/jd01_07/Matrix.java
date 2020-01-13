package by.it.cherkas.jd01_07;

import java.util.Arrays;

class Matrix extends AbstractVar {
     private double [][] value;

         Matrix(double[][] value) {
             this.value = value;
    }

    

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
