package by.it.kuzmichalex.jd01_04;

public class TaskC {
    /***
     * Поиск первого индекса элемента в массиве, чъё значние равно указанному
     * @param inArr массив, к котором производим поиск
     * @param  valueToSearch Значение,которе требуется найти
     * @return индекс елемента в массиве. Если елемент не найден, возвращается -1
     */
    static int getIndexOfElement(double[] inArr, double valueToSearch) {
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] == valueToSearch) return i;
        }
        return -1;
    }

    /**
     * Формирование массива double из строки разделённых пробелами чисел
     * Используем InOut
     */
    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);
        double valueOfFirst = arr[0];
        double valueOfLast = arr[arr.length - 1];

        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);
        System.out.println("Index of first element=" + getIndexOfElement(arr, valueOfFirst));
        System.out.println("Index of last element=" + getIndexOfElement(arr, valueOfLast));

    }

    /**
     * Сортировка массива методом Хоара (быстрая сортировка)
     *
     * @param array массив чисел, которыенадо отсортировать
     * @author kuzmichalex
     */
    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length - 1;
        if (right < 1) return; //Один элемент или пустой массив - сортировать нечего, выходим.
        mergeSort(array, left, right);
    }

    /**
     * Рекурсивная функиця для сортировки. Выполняем деление массива на 2 части и снва её вызываем.
     *
     * @param arr   - массив для сортировки
     * @param left  индекс начала участка массива, который надо отсортировать
     * @param right индекс окончания участка массива, когторый надо отсортировать
     */
    private static void mergeSort(double[] arr, int left, int right) {
        /*System.out.print("Вызов для [" + left +";"+right+"]: ");
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%4.0f ",arr[i]);
        }
        System.out.println();*/

        //Если сортировать нечего, выходим
        if (left >= right) return;
        //Если у нас только 2 элемента, то просто сравним, переставим если надо и выйдём.
        if ((left + 1) == right) {
            if (arr[left] <= arr[right]) return;    //Нормуль можно выходить без перестановки
            double tempValue = arr[left];
            arr[left] = arr[right];
            arr[right] = tempValue;
            return;     //Переставим и выйдем.
        }
        //Элементов 3 или более. Можем поиграть в partition
        double baseValue = arr[left];   //Опорное значение
        int middle = left;  //Индекс середины. То, откуда всё больше базового значения
        for (int i = (left + 1); i <= right; i++) {
            if (arr[i] <= baseValue) {
                middle++;
                double tempValue = arr[middle];
                arr[middle] = arr[i];
                arr[i] = tempValue;
            }
        }
        double tempValue = arr[middle];
        arr[middle] = arr[left];
        arr[left] = tempValue;
        //System.out.println("Базовый "+baseValue +" Разделили по "+middle);
        //разделили. [left;middle] элементы меньше или равны опорному. В [middle+1,right] - больше опорного
        //Всё, что нам осталось, позвать самим себя и будет счастье.
        mergeSort(arr, left, middle - 1);
        mergeSort(arr, middle + 1, right);
    }

    /**
     * @param arr   массив, в котором производим поиск
     * @param value значение, которое надо найти
     * @return индекс найдоенного значения. Есди его нет, то возвращается -1
     * @author kuzmichalex
     */
    static int binarySearch(double[] arr, double value) {
        int right = arr.length - 1;
        if (right < 0) return -1;   //Пустой массив.
        int left = 0;
        do {
            int middle = (right + left) >> 1;
            if (arr[middle] >= value) {  //Нужное число в [left,middle]
                right = middle;
                if (left == right) {        //Дальше искать некуда
                        if(arr[middle]==value)return middle;
                        else return -1;
                    }
                continue;
            }
            if (arr[middle] < value) {                 //Нужное число в [middle,]
                left = middle + 1;
                if (left>right) return -1;
            }
        } while (true);
    }


    public static void main(String[] args) {
        double[] arr = {5, 2, 3, 5};
        //  double[] arr={3,1,2,2,1,3};
        mergeSort(arr);
        InOut.printArray(arr);
    }

}
