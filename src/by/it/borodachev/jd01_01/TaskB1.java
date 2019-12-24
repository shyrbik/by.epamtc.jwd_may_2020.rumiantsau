package by.it.borodachev.jd01_01;

import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        int a=0;
        String retSquare=new String();
        Scanner inp=new Scanner(System.in);
        a=inp.nextInt();
        retSquare=String.valueOf (a*a);
  	System.out.println(retSquare);
    }
}
