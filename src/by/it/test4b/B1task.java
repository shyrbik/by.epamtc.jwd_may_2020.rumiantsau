package by.it.test4b;

import java.util.Scanner;

public class B1task {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("введите количество сотрудников");
        int n=scanner.nextInt();
        System.out.println("ввоод зарплаты через пробел, в конце Enter");
        char[] in = scanner.nextLine().toCharArray();


        int [][] maszp = new int[3][4];
        maszp[0][0] = in [0];
        maszp[0][1] = in [1];
        maszp[0][2] = in [2];

        for (char c : in) {
            System.out.println(in[c]);
        }
//        int[][] maszp = new int[n][4];



     //   = Integer.parseInt(scanner.next());
        System.out.println("вывод элемента массива"+maszp[0][0]);

        /*
        String[] fam = new String[n];
        //Ввод фамилий
        System.out.println("Введите фамилии сотрудников через Enter");
        for (int i = 0; i < n; i++) {
            fam[i] = scanner.next();
        }
        System.out.println("Тест проверка записи в массив");
        System.out.println(fam[2]);
        System.out.println(fam[3]);

        */


        //Ввод зарплаты за 4 квартала
        System.out.println("ввод зарплат");
        /*
        maszp[0][0]=scanner.nextInt();
        for (int i = 1; i < n; i++) {
            //  System.out.println("Зарплата товарища "+fam[i]);
            for (int j = 1; j < 4; j++) {
                //  int sc = scanner.nextInt();
                maszp[i][j] =  scanner.nextInt();
            }*/

        }



    }

