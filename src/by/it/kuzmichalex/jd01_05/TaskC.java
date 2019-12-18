package by.it.kuzmichalex.jd01_05;

import static java.lang.Math.*;

/**
 * Класс для тестового задания C
 */
public class TaskC {
    public static void main(String[] args) {
        double[] arr = createArray(28);
    }

    /**
     * Формирование массива  double c заданнным количеством элементов
     * со значениями функции при диапазоне аргументов функции [5.33, 9]
     */
    private static double[] createArray(int countOfElements) {
        double x;
        double deltaX;
        if ((countOfElements < 20) || (countOfElements > 40)) {
            System.out.println("размерность массива не предусмотрена заданием! Вы чо!?");
            return null;
        }
        x = 5.33;
        deltaX = (9.0 - 5.33) / (double)(countOfElements-1);
        double[] returnArr = new double[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            //Из-за ошибок втискитвания вещественного числа в double точно на 9 можем и не выйти.
            if (i == (countOfElements - 1)) x = 9;
            returnArr[i] = cbrt(pow(x, 2) + 4.5);
            System.out.println("i:" + i + " X:" + x + " z:" + returnArr[i]);
            x += deltaX;
        }
        return returnArr;
    }
}
