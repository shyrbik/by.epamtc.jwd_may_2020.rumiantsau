package by.it.borodachev.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
     private double [] value;
      private int ValueLength;
      public int length() { return ValueLength;}
      public double getValue(int i) throws VectorException {
        if (i<0) throw new VectorException("Неверный индекс");
        if (i>=value.length) throw new VectorException ("Неверный индекс");
        return this.value [i];
    }
    public Vector (double... args) throws VectorException{
        if (args.length == 0) throw new VectorException ("Длина массива =0");
        ValueLength=args.length;
        value=new double [ValueLength];
        for (int i = 0; (i < ValueLength); i++) {
          value[i]=args[i];
        }
    }
    public Vector (Vector vc) throws VectorException{
        if (vc.length() == 0) throw new VectorException ("Длина массива =0");
        ValueLength=vc.length();
        value=new double [ValueLength];
        for (int i = 0; (i < ValueLength); i++) {
            value[i]=vc.getValue(i);
        }
    }
    public Vector (String str) throws VectorException{
          str=str.trim();
        String[] valStr;
        Pattern pat= Pattern.compile("[^{}][0-9,/.]+");
        Matcher m=pat.matcher(str);
        if (m.find()) {
            valStr = m.group().split(",");}
           else {
               throw new VectorException ("Длина массива =0");
           }
        if (valStr.length == 0) throw new VectorException ("Длина массива =0");
        ValueLength=valStr.length;
        value=new double [ValueLength];
        for (int i = 0; (i < ValueLength); i++) {
            value[i]=new Double (valStr[i]);
        }
    }
    @Override
    public String toString() {
          String tmpStr;
        StringBuilder retStr =new StringBuilder("{");
        for (int i = 0; i < ValueLength-1; i++) {
            tmpStr=Double.toString(value[i]);
            retStr.append(tmpStr.trim());
            retStr.append(", ");
        }
        tmpStr=Double.toString(value[ValueLength-1]);
        retStr.append(tmpStr.trim());
        retStr.append("}");
        return retStr.toString();
    }
}
