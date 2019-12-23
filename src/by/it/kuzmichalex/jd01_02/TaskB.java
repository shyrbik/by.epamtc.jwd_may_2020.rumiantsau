package by.it.kuzmichalex.jd01_02;

import java.util.Scanner;

public class TaskB {
    //Вывод матрицы 1 - 25
    public static void step1() {
        final int matrixSize = 5;
        for (int x = 0; x < matrixSize; x++) {
            for (int y = 0; y < matrixSize; y++) {
                System.out.print((x * matrixSize + y + 1) + " ");
            }
            System.out.println();
        }
    }

    //вывод  названия месяца, соответствующего числу 1 - 12
    public static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
            default:    //Какого термидора вам надо!?
                System.out.println("нет такого месяца");
        }
    }

    //решение квадратного уравнения
    public static void step3(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Э! Вы там чего!? это не квадратное уравнение, а линейное. Стыдно испоользовать комптьтер для такой мелочёвки!");
            return;
        }

        double discriminant;
        discriminant = b * b - 4 * a * c;
        if (discriminant < 0.0) {
            System.out.println("корней нет");
            return;
        }
        //Один корень. Дурацкая парабола лишь касается оси
        if (discriminant == 0.0) {
            System.out.println(((b * -1.0) + Math.sqrt(discriminant)) / (2.0 * a));
            return;
        }
        //Два корня
        System.out.print(((b * -1.0) + Math.sqrt(discriminant)) / (2.0 * a) + " ");
        System.out.print(((b * -1.0) - Math.sqrt(discriminant)) / (2.0 * a));
        System.out.println();
    }


    public static void main(String[] args) {
        step1();

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        step3(a, b, c);
    }


}

