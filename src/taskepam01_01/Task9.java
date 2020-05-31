package taskepam01_01;

public class Task9 {
    public static void main(String[] args) {
        int sum = 3;
        int finalSum = 3;
        for (int i = 3; i < 11; i++) {
            finalSum = sum * (sum + i);
            sum = sum + i;
        }
        System.out.println("finalSum = " + finalSum);

    }
}
