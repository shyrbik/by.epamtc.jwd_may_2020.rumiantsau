package by.it.filipovich.jd01_07;

import java.util.Scanner;

public class Scalar extends Var {
    private double value;

    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }
    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    public String toString(){
      return Double.toString(value);
    }
}
