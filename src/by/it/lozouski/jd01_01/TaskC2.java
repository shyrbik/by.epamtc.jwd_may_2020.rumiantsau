package by.it.lozouski.jd01_01;

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
        Scanner sc1 = new Scanner(System.in);
        int xDec = sc1.nextInt();
        int yDec = sc1.nextInt();
        convert(xDec, yDec, 10);
        convert(xDec, yDec, 2);
        convert(xDec, yDec, 16);
        convert(xDec, yDec, 8);
    }

    private static void convert(int a, int b, int c) {
        int sum = a + b;
        switch (c) {
            case 2:
                System.out.println("BIN:" + Integer.toBinaryString(a) + "+" + Integer.toBinaryString(b) + "=" + Integer.toBinaryString(sum));
                break;
            case 16:
                System.out.println("HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) + "=" + Integer.toHexString(sum));
                break;
            case 8:
                System.out.println("OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) + "=" + Integer.toOctalString(sum));
                break;
            default:
                System.out.println("DEC:"+ a + "+" + b + "=" + sum);
        }
    }
}
