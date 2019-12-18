package by.it.kuzmichalex.jd01_05;

import static java.lang.Math.*;

/**
 * Класс для тестового задания C
 */
public class TaskC {
    public static void main(String[] args) {
        double[] arr = createArray(27);
        double geomMean=getGeomMean(arr);
        System.out.println("Среднее геометрическое "+geomMean);
        runTask7();


    }
    /**
     * Задание 7, с псевдографикой
     **/
    private static void runTask7() {
        //intarrayA
        for (int i = 0; i <31 ; i++) {

        }
    }

    /**
     * Вычисление среднего геометрического
     * */
    private static double getGeomMean(double[] arr) {
        double retValue=0;
        for (int i = 0; i <arr.length ; i++) {
            retValue+=log10(arr[i]);
        }
        return retValue;
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
           // System.out.println("i:" + i + " X:" + x + " z:" + returnArr[i]);
            x += deltaX;
        }
        return returnArr;
    }
}
