package taskepam01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;

public class Task3 {
    public static void main(String[] args) throws IOException {
        double a, b, c;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input A ");
        a = Double.parseDouble(input.readLine());
        System.out.println("Input B ");
        b = Double.parseDouble(input.readLine());
        System.out.println("Input C ");
        c = Double.parseDouble(input.readLine());

        if(a > b | b > c) {
            a = abs(a*2);
            b = abs(b*2);
            c = abs(c*2);
        }

        System.out.println("a = " + a + " / b = "+ b + " / c = " + c);


    }
}
