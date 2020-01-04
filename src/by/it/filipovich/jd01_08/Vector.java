package by.it.filipovich.jd01_08;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value){
       this.value = new double[value.length];
       System.arraycopy(value, 0, this.value, 0,value.length);
    }

    public Vector(Vector vector){
        this(vector.value);
    }

    public Vector(String strVector){
        //Pattern pattern = Pattern.compile("[^}{]+");
        //Matcher matcher = pattern.matcher(strVector);
        //if (matcher.find()) {
            String[] a = strVector.replaceAll("\\}","")
                                    .replaceAll("\\{","")
                                    .replaceAll("\\,","")
                                    .split(" ");

            double[] arr = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = Double.parseDouble(a[i]);
            }
            this.value = new double[arr.length];
            System.arraycopy(arr, 0, this.value, 0, arr.length);

        //}
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

    @Override
    public Var add(Var other) {
        if(other instanceof Vector) {
            double[] sum = new double[this.value.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i]+((Vector) other).value[i];
            }
            return new Vector(sum);
        }
        return super.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Vector) {
            double[] sub = new double[this.value.length];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = this.value[i]-((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        return super.add(this);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
