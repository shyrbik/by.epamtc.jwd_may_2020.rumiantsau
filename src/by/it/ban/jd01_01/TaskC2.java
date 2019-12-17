package by.it.ban.jd01_01;

import java.math.BigInteger;
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
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        BigInteger aa = new BigInteger(String.valueOf(a));
        BigInteger bb = new BigInteger(String.valueOf(b));
        BigInteger cc = new BigInteger(String.valueOf(c));

        System.out.println("DEC:"+a+"+"+b+"="+c);
        System.out.println("BIN:"+aa.toString(2)+"+"+bb.toString(2)+"="+cc.toString(2));
        System.out.println("HEX:"+aa.toString(16)+"+"+bb.toString(16)+"="+cc.toString(16));
        System.out.println("OCT:"+aa.toString(8)+"+"+bb.toString(8)+"="+cc.toString(8));

    }

}
