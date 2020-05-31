package taskepam01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfDay;
        int day = 0, month = 0, res;
        int[] daysOfMounth = {31,28,31,30,31,30,31,31,30,31,30,31};

        System.out.println("Input Number Of Day");
        numberOfDay = Integer.parseInt(input.readLine());

        for (int i = 0; i < daysOfMounth.length; i++) {
            res = numberOfDay - daysOfMounth[i];
            if (res < 0)
            {
                day = numberOfDay;
                month = i+1;
                break;
            }
            numberOfDay = res;
        }

        System.out.println("Current Date: Day " + day + " / Month " + month);







    }
}
