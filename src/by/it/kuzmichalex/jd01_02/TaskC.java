package by.it.kuzmichalex.jd01_02;

import java.util.Scanner;

public class TaskC {

    //Создание и заполнение массива nxn
    public static int[][] step1(int n) {
        boolean maxValueGenerated;
        boolean minValueGenerated;
        int[][] arr;
        arr = new int[n][n];
        //Создали. заполним!  И будем повторять это пока не получим числа от -n до n
        do {
            maxValueGenerated = false;
            minValueGenerated = false;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    arr[x][y] = (int) (Math.random() * (2.0 * n + 1.0)) - n;
                    if (arr[x][y] == n) maxValueGenerated = true;
                    if (arr[x][y] == (n * -1)) minValueGenerated = true;
                    if (n == 1) {
                        minValueGenerated = true;
                        maxValueGenerated = true;
                    }
                }
            }
        }
        while (minValueGenerated == false || maxValueGenerated == false);
        //Похвастаемся достижением
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println(" ");
        }
        return arr;
    }

    //Нахождение суммы между первым и вторым жлементами каждой строки
    public static int step2(int arr[][]) {
        int summ = 0;             //Сумма котрую надо вернуть
        int stageCounter;          //Состояние. 0 - поиск 1 - суммирование 2 - нашли
        int sumOfString;

        int ySize = arr.length;
        int xSize = arr[0].length;

        for (int y = 0; y < ySize; y++) {
            stageCounter = 0;
            sumOfString = 0;
            for (int x = 0; x < xSize; x++) {
                switch (stageCounter) {
                    case 0:     //Начинаем считать
                        if (arr[y][x] > 0) {
                            stageCounter = 1;
                        }
                        break;
                    case 1:     //Считаем или выходим
                        if (arr[y][x] > 0) {
                            stageCounter = 2;
                            continue;
                        } else {
                            sumOfString += arr[y][x];
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("ммм-да... И как вы до этого дошли");
                }
            }
            summ += (stageCounter == 2) ? sumOfString : 0;
        }
        System.out.println(summ);
        return summ;
    }

    //Удаление максимума из массива
    public static int[][] step3(int[][] arr) {
        int ySize = arr.length;
        int xSize = arr[0].length;

        //Найдём максимальное значение
        int maxValue = Integer.MIN_VALUE;
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (arr[y][x] > maxValue) maxValue = arr[y][x];
            }
        }
        //Отметим индексы строк и столбцов, где есть максимумы
        boolean[] xToDelete = new boolean[xSize];
        boolean[] yToDelete = new boolean[ySize];
        int xSizeNew = xSize;
        int ySizeNew = ySize;
        //for (int x = 0; x < xSize; x++) xToDelete[x] = false;
        //for (int y = 0; y < ySize; y++) yToDelete[y] = false;
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (arr[y][x] == maxValue) {    //Это нуждается в обструкции
                    if (!xToDelete[x]) {
                        xSizeNew--;
                        xToDelete[x] = true;
                    }
                    if (!yToDelete[y]) {
                        ySizeNew--;
                        yToDelete[y] = true;
                    }
                }
            }
        }

        //Создадим новый массив требуемого размера и скопируем в него занчения старого, кроме вычеркнутых строк
        int[][] newArr = new int[ySizeNew][xSizeNew];
        int newY = 0;
        int newX = 0;
        for (int y = 0; y < ySize; y++) {
            if (!yToDelete[y]) { //Эта строка нам таки-нужна
                newX = 0;
                for (int x = 0; x < xSize; x++) {
                    if (!xToDelete[x]) {
                        newArr[newY][newX] = arr[y][x];
                        newX++;
                    }
                }
                newY++;
            }
        }
        //Выведем. Если честно, тио уже подзадолбало. Скоро придётся делаьб метод для вывода массива.
        for (int y = 0; y < ySizeNew; y++) {
            for (int x = 0; x < xSizeNew; x++) System.out.print(newArr[y][x] + " ");
            System.out.println();
        }
        return newArr;
    }

    public static void main(String[] args) {

        int[][] mas;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mas = step1(n);

        int step2summ = step2(mas);

        int[][] step3arr = step3(mas);
    }
}
