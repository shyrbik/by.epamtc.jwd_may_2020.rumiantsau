package by.it.potapovich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int[] i : step1(n)) {
            for (int value : i) {
                System.out.print(value + " ");
            }
        }
        System.out.println();

        for (int[] i : step1(n)) {
            for (int value : i) {
                if (value == n || value == -n) {
                    System.out.println("WOW! " + value);
                }
            }

        }
    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];

        boolean isPositiveNExists = false;
        boolean isNegativeNExists = false;
        boolean toggle = false;
        int value;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (toggle) {
                    value = (int) (Math.random() * n + 1);
                    toggle = false;
                } else {
                    value = (int) (Math.random() * -n - 1);
                    toggle = true;
                }
                mas[i][j] = value;

                if (value == n) {
                    isPositiveNExists = true;
                }
                if (value == -n) {
                    isNegativeNExists = true;
                }
            }
            if (n - i == 1 && !isPositiveNExists || !isNegativeNExists) {
                i = 0;
            }
        }
        return mas;
    }
}
//       for (int i = 0; i < n; i++) {
//           for (int j = 0; j > -n; j--) {
//
//               System.out.println(i+j);
//               if (i == n ) {
//                   if (j==-n) {
//                       System.out.println(i+j);
//                   }
//               }
//           }
//      }
// for (int i = 0; i <= n; i++) {
//  for (int j = 0; j <= n; j++) {


//   }

//}
    /*    int k = (int) (Math.random() * n);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = k;
                k++;
            }
        }
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas.length; j++) {
                        if(i==n&&j==-n){
                            i=n;j=-n;
                        }
                        System.out.println(mas[i][j]);



                System.out.println(mas [i][j]);
            }
            }


       */
//    return mas;
//}
//}


//   for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//  if (i==n){
//       if (j==-n){
// System.out.println(mas[i][j]);
//}
//    }
//i = (int) (Math.random() * 10);
//j = (int) (Math.random() * 10);
//  while (i !=n) {
//    i++;
//    while (j != -n) {
//         j++;


//    for (int i = 0; i < mas.length; i++) {
//       for (int j = 0; j < mas.length; j++) {
//         if (i == n && j == -n) {
//          System.out.println(mas[i][j]);
//       } else if (i == -n && j == n) {
//           System.out.println(mas[i][j]);
//    }
//}
//    }




