package by.it.lozouski.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        int[][] mas = step1(n);
        System.out.print('\n');
        System.out.print(step2(mas));
        System.out.println();
        step3(mas);
    }

    private static int[][] step1(int n) {
        int min = -n;
        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < n; j++) {
                    int rand = min + (int) (Math.random() * ((n - min) + 1));
                    if (rand != n && rand != min) mas[i][j] = rand;
                    else {
                        if (rand == n) mas[i][j] = n;
                        else mas[i][j] = min;
                        j = n;
                    }
                }
        }

        for (int[] row : mas) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print('\n');
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int[] getRows : mas) {
            boolean flag = false;
            for (int j = 0; j < mas.length; j++) {
                if (!flag && getRows[j] >= 0) flag = true;
                else if (flag && getRows[j] >= 0) break;
                else if (flag && getRows[j] < 0) sum += getRows[j];
            }
        }
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        for (int[] getRows : mas) {
            for (int i = 0; i < mas.length; i++) {
                if (getRows[i] > max) max = getRows[i];
            }
        }
        int[] indArr1 = new int[mas.length];
        int[] rowArr1 = new int[mas.length];
        int indI = 0;
        int rowI = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    indArr1[indI] = j;
                    rowArr1[rowI] = i;
                    indI++;
                    rowI++;
                }
            }
        }
        int[] indArr2 = new int[indI];
        int[] rowArr2 = new int[rowI];
        System.arraycopy(indArr1, 0, indArr2, 0, indI);
        System.arraycopy(rowArr1, 0, rowArr2, 0, rowI);
        int[][] newMas = new int[mas.length - rowArr2.length][mas.length - indArr2.length];
        int newRowI = 0;
        for (int j = 0; j < mas.length; j++) {
            boolean exit = false;
            for (int j1 = 0; j1 < rowArr2.length; j1++) {
                if (rowArr2[j1] == j) {
                    exit = true;
                    break;
                }
            }
            if (exit) break;
            int newElemI = 0;

            for (int k = 0; k < mas[j].length; k++) {
                for (int k1 = 0; k1 < indArr2.length; k1++) {
                    if (indArr2[k1] == k) break;
                    newMas[newRowI][newElemI] = mas[j][k];
                    newElemI++;
                }
            }
            newRowI++;
        }
        for (int i = 0; i < newMas.length; i++) {
            for (int j = 0; j < newMas.length; j++) {
                System.out.print(newMas[i][j]+" ");
            }
            System.out.print('\n');
        }
        return newMas;
    }
}