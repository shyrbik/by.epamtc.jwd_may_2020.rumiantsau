package by.it.drozd.jd01_01;

import javax.xml.bind.SchemaOutputResolver;
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
        int a=sc.nextInt();
        Scanner sca=new Scanner(System.in);
        int b=sc.nextInt();
        int c=a+b;
        System.out.println("Sum =" +" "+c);
    }




}
