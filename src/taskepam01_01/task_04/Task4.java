package taskepam01_01.task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

public class Task4 {
    public static void main(String[] args) throws IOException {
        double fX;
        double x = 10;

        if (x > 13)
        fX = -1 * 3 / (x +1);
        else
            fX = -1 * pow(x, 3) + 9;

        System.out.println("F(x) = " + fX);


    }
}
