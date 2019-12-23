package by.it.borodachev.jd01_01;

import java.util.Scanner;

public class TaskC2 {

    public static void main(String[] args) {
        int a;
        int b;
        int rez;
        String aStr = new String();
        String bStr = new String();
        String rezStr = new String();
        Scanner inp=new Scanner(System.in);
        a=inp.nextInt();
        b=inp.nextInt();
        rez=a+b;
        System.out.println(" DEC:"+a+"+"+b+"="+rez);
        aStr = Integer.toString(a,2);
        bStr = Integer.toString(b,2);
        rezStr = Integer.toString(rez,2);
        System.out.println(" BIN:"+aStr+"+"+bStr+"="+rezStr);
        aStr = Integer.toString(a,16);
        bStr = Integer.toString(b,16);
        rezStr = Integer.toString(rez,16);
        System.out.println(" HEX:"+aStr+"+"+bStr+"="+rezStr);
        aStr = Integer.toString(a,8);
        bStr = Integer.toString(b,8);
        rezStr = Integer.toString(rez,8);
        System.out.println(" OCT:"+aStr+"+"+bStr+"="+rezStr);

    }
}
