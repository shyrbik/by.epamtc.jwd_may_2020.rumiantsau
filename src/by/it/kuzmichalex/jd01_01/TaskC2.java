package by.it.kuzmichalex.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int iInput1 = sc.nextInt();
        int iInput2 = sc.nextInt();
        int iOutput = iInput2 + iInput1;
        String sOut;

        System.out.println("DEC:" + iInput1 + "+" + iInput2 + "=" + iOutput);

        sOut="BIN:" + Integer.toString(iInput1,2) +"+"+ Integer.toString(iInput2,2) + "=" + Integer.toString(iOutput,2);
        System.out.println(sOut);

        sOut="HEX:" + Integer.toString(iInput1,16) +"+"+ Integer.toString(iInput2,16) + "=" + Integer.toString(iOutput,16);
        System.out.println(sOut);

        System.out.printf("OCT:%1$o+%2$o=%3$o",iInput1,iInput2,iOutput);
        System.out.println("");
    }

}
