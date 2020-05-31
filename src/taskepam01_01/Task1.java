package taskepam01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double a, b, c;
        double result;
        System.out.println("a = ");
        a = Double.parseDouble(input.readLine());
        System.out.println("b = ");
        b = Double.parseDouble(input.readLine());;
        System.out.println("c = ");
        c = Double.parseDouble(input.readLine());;

        result = b + sqrt(b*b + 4*a*c) / (2 *a) - a*a*a*c + pow(b, -2);
        System.out.println("result =" + result);

    }








}
