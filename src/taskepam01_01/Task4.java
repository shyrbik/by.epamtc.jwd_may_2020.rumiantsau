package taskepam01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double fX;
        double x;
        System.out.println("Input X");
        x = Double.parseDouble(input.readLine());
        if (x > 13)
        fX = -1 * 3 / (x +1);
        else
            fX = -1 * pow(x, 3) + 9;

        System.out.println("F(x) = " + fX);


    }
}
