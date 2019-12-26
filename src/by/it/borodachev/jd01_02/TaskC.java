package by.it.borodachev.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        int masLength= inp.nextInt();
        int mas[][]=step1(masLength);
        printArray(mas);
        System.out.println(step2(mas));
       printArray(step3(mas));


    }

    private static  int[ ][ ]  step3(int[][] mas) {
        int maxElem = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > maxElem) {
                    maxElem = mas[i][j];
                }
            }
        }
        int delRow[] = new int[mas.length];
        int delCol[] = new int[mas.length];
        int rowCount = mas.length;
        int colCount = mas[0].length;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == maxElem) {
                    if (delRow[i] != 1) {
                        delRow[i] = 1;
                        rowCount--;
                    }
                    if (delCol[j] != 1) {
                        delCol[j] = 1;
                        colCount--;
                    }
                }
            }

           }
        int retmas[][] = new int [rowCount][colCount];
        int i=0;
        int i1=0;
        do {
            if (delRow[i1]!=1) {
                int j = 0;
                int j1 = 0;
                do {
                    if (delCol[j1] != 1) {
                        retmas[i][j] = mas[i1][j1];
                        j++;
                    }
                    j1++;
                } while (j < retmas[0].length);
                i++;
            }
            i1++;
        } while (i<retmas.length);
        return retmas;
        }


    private static void printArray(int[][] mas) {
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas[i].length ; j++) {
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int step2(int[][] mas) {
        int retSum=0;
        for (int i = 0; i <mas.length ; i++) {
            int firstElement=-1;
            int lastElement =-1;
            for (int j = 0; j < mas[i].length; j++) {
               if((mas[i][j] >0) && (firstElement ==-1)) {firstElement=j;}
               else
                if((mas[i][j] >0)   && (lastElement==-1)) {lastElement=j;}
            }

             for (int j = firstElement+1; j < lastElement; j++) {
                retSum=retSum+mas[i][j];
            }

        }
        return retSum;
    }

    private static  int[][] step1(int n) {
        int mas[][]=new int[n][n];
        int minValue =n;
        int maxValue=-1*n;
        boolean findMin=false;
        boolean findMax=false;
        Random random = new Random();

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j]=random.nextInt(2*n)-n;

                if (mas[i][j] ==minValue)  {findMin=true;
                }
                else {
                    if (mas[i][j] == maxValue) {
                        findMax = true;
                    }
                }
                    if (findMin && findMax) {return mas;
                    }
            }
        }
/*нет или минимума или максимума добавим*/
        if (findMin) {
            if (mas[0][0]==minValue) {mas[1][0]=maxValue;}
            else {mas[0][0]=maxValue;}
             }
        if (findMax) {
            if (mas[0][0]==maxValue) {mas[1][0]=minValue;}
            else  {mas[0][0]=minValue;}
                 }
        return mas;
    }

}
