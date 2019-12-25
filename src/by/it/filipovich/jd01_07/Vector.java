package by.it.filipovich.jd01_07;


public class Vector extends Var{

    private double[] value;

    public Vector(double[] value){
       this.value = new double[value.length];
       System.arraycopy(value, 0, this.value, 0,value.length);
    }

    public Vector(Vector vector){
        this.value = new double[vector.value.length];
        System.arraycopy(vector,0,this.value,0,vector.value.length);
    }

    public Vector(String strVector){

    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i<value.length; i++) {
            sb.append(value[i]);
            if(i != value.length-1)
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
