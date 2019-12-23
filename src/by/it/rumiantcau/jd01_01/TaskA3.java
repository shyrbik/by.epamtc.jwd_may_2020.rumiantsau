package by.it.rumiantcau.jd01_01;
/*
Измените переменные и строку вывода в программе так,
чтобы она рассчитывала и печатала следующее выражение
3*3+4*4=25
 */

class TaskA3 {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        i = i+1;
        j =j+1;

        int k = i*i + j*j;
        System.out.println(i+"*"+i+"+"+j+"*"+j+"=" + k);
    }
}
