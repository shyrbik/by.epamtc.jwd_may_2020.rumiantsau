package by.it.borodachev.jd01_07;

public class Scalar extends Var {
     private double value;
     public double getValue() {return this.value;}
     public Scalar(double var) throws ScalarException {
          this.value=var;
     }
     public Scalar(Scalar Sc) throws ScalarException
     {this.value = Sc.getValue();}
    public Scalar(String var) throws ScalarException {
        this.value= new Double(var);
    }
    @Override
    public String toString() {
      return Double.toString(this.value);
    }
}
