package by.it.kuzmichalex.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        final int  countOfPayments=4;  //Количество зарплат для каждой персоны
        final String divideLine="---------------------------------------------------------";

        Scanner sc = new Scanner(System.in);
        int countOfPersons;
        countOfPersons = sc.nextInt();
        //Вводим массив персон полулчающих зарплату
        String[] listOfPersons = new String[countOfPersons];
        for (int i = 0; i <countOfPersons ; i++) {
            listOfPersons[i]=sc.next();
        }
        //Вводим зарплаты для за квартал для каждой персоны
        int[][] arrOfPayments = new int[countOfPersons][countOfPayments];
        for (int i = 0; i <countOfPersons ; i++) {
            System.out.println("Введите зарплату для " +listOfPersons[i]);
            for (int j = 0; j <countOfPayments ; j++) {
                arrOfPayments[i][j]=sc.nextInt();
            }
        }
        //Выведем итого и посчитаем, чё там и как в среднем
        System.out.println(divideLine);
        System.out.println("Фамилия     Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println(divideLine);

        int itogoAll=0;
        for (int i = 0; i <countOfPersons ; i++) {
            int itogoByPersona=0;
            System.out.printf("%10s: ",listOfPersons[i]);
            for (int j = 0; j <countOfPayments ; j++) {
                System.out.printf("%-10d",arrOfPayments[i][j]);
                itogoByPersona+=arrOfPayments[i][j];
            }
            System.out.printf("%-10d%n",itogoByPersona);
            itogoAll+=itogoByPersona;
        }
        System.out.println(divideLine);
        System.out.printf("Итого%10d%n",itogoAll);
        System.out.printf("Средняя%12.4f%n",(double)itogoAll/(double)(countOfPersons*countOfPayments) );
    }
}