package by.it.ban.jd01_02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] mas,mas2;
        mas=step1(n);
        //System.out.println("длина массива="+mas.length);
        int sum=step2(mas);
        mas2=step3(mas);

    }

    private static int[][] step1(int n) {
        int[][] ms1=new int[n][n];
        boolean min=false;
        boolean max=false;
        double d;
        BigDecimal bd;


        while (min==false ||max==false) {
            for (int i = 0; i < ms1.length; i++) {
                for (int j = 0; j < ms1.length; j++) {
                    if(i==0&&j==0){
                        max=false;
                        min=false;
                    }
                    d=(2.0 * (double) n * Math.random() - (double)n);
                    bd= new BigDecimal(Double.toString(d));
                    bd = bd.setScale(0, RoundingMode.HALF_UP);
                    ms1[i][j] = bd.intValue();
                    if (ms1[i][j]==n){
                        max=true;
                    }
                    if (ms1[i][j]==-n){
                        min=true;
                    }
                }
            }
        }
        for (int i = 0; i < ms1.length; i++) {
            for (int j = 0; j < ms1.length; j++) {
                System.out.print(ms1[i][j]+" ");
            }
            System.out.println();
        }
        return ms1;
    }

    private static int step2(int[][] mas) {
        int allsum=0;
        for (int i = 0; i < mas.length; i++) {
            int j1 = 0;
            while (j1<mas.length && mas[i][j1]<=0) {
                j1++;
            }
            int j2=j1+1;
            while (j2<mas.length && mas[i][j2]<=0) {
                j2++;
            }
            //System.out.println("для ряда "+i+" с "+j1+" по "+j2);

            if (j1<mas.length && j2< mas.length && j2>j1){
                //System.out.println("-*/-*/ "+j1+" "+j2);
                for (int k = j1+1; k < j2; k++) {
                    allsum+=mas[i][k];
                }
            }
        }
        System.out.println(allsum);
        return allsum;
    }

    private static int[][] step3(int[][] mas) {
        int max=mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j]>max){
                    max=mas[i][j];
                }
            }

        }
        //System.out.println("max element="+max);
        boolean[] delrows = new boolean[mas.length];
        boolean[] delcols = new boolean[mas.length];
        int row=0;
        int col=0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (max==mas[i][j]){
                    delrows[i]=true;
                    delcols[j]=true;
                }

            }

        }
        row=0;
        col=0;
        for (int i = 0; i < delrows.length; i++) {
            if (delrows[i]==false){
                row++;
            }
        }
        for (int i = 0; i < delcols.length; i++) {
            if(delcols[i]==false){
                col++;
            }
        }
        if (col==0 ||row==0){
            System.out.println("row="+row+" col="+col);
            int[][] nullmas=null;
            return nullmas;
        }
        int[][] newmas = new int[row][col];
        col=0;
        row=0;
        for (int i = 0; i < mas.length; i++) {
            if (delrows[i]==false){
                col=0;
                for (int j = 0; j < mas.length; j++) {
                    if (delcols[j]==false){
                        newmas[row][col]=mas[i][j];
                        col++;
                    }
                }
                row++;
            }
        }

        for (int i = 0; i < newmas.length; i++) {
            for (int j = 0; j < newmas[i].length; j++) {
                System.out.print(newmas[i][j]+" ");
            }
            System.out.println();
        }
        return newmas;
    }
}
