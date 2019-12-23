package by.it.kuzmichalex.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ax; //К чёрту венгерскую нотацию!
        int bx; //Переменные надо называть в честь регистров процессора 8086!
        ax=sc.nextInt();    //многа букв на ассемблере
        bx=sc.nextInt();    //чучуть букв на ассемблере. Патамучта подпрограмма уже есть.
        ax+=bx;             //add ax,bx  ура, почти ассемблер!
        System.out.println("Sum = " + ax);
    }



}
