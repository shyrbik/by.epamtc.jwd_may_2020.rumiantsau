package taskepam01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int hundreds, dozens, units;

        int number = Integer.parseInt(input.readLine());

        units = number % 100 % 10;
        dozens = (number - units) / 10 % 10;
        hundreds = (number - dozens*10 - units)/100;

        System.out.println("Sum = " + (units + dozens + hundreds));
        System.out.println("Div = " + units * dozens * hundreds);
        //число, полученное перестановкой цифр сотен и десятков;
        System.out.println("Reverse hundreds and dozens = " + (dozens*100 + hundreds * 10 + units));
        //четырехзначное число, полученное приписыванием цифры единиц в качестве цифры тысяч (например, из числа 137 необходимо получить число 7137).
        System.out.println("4count number = " + (units*1000 + number));




    }
}
