package by.it.popkov.jd01_13;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            try {
                String row = scanner.next();
                if (row.equals("END")) break;
                int num = Integer.parseInt(row);
                sum = sum + num;
                System.out.println("Num=" + num + " sqrt of sum=" + Math.sqrt(sum));
            }catch (RuntimeException e){
                UseFull.printException(e, TaskB.class.getName());
            }
        }
    }
}
