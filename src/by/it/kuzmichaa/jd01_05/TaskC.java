package by.it.kuzmichaa.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        int size = 21;
        double [] arr = new double[size];
        double start = 5.33;
        double end = 9;
        for (int i = 0; i < size ; i++) {
            double x = start + ((end-start)/size-1)*i;
            arr[i] = Math.cbrt(x*x+4.5);
        }
        System.out.println("Массив А");
        PrintArr(arr, "A", 5);
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>3.5){
                count ++;
            }
        }
        double [] array = new double[count];
        double acc = 1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > 3.5) {
                array[array.length - count] = arr[i];
                count--;
                acc = acc*arr[i];
            }
        }
        acc = Math.sqrt(acc);
        System.out.println("Массив А1");
        PrintArray(array, "A1", 3);
        System.out.println("Среднее геометрическое массива А1 = " + acc);

    }

    static void PrintArr (double [] arg, String name, int columnCount){
        for (int i = 0; i < arg.length; i++) {
            System.out.printf("%s[%3d] = %g", name, i, arg[i]);
            if ((i+1)%columnCount==0 || i+1==arg.length)
                System.out.println();
        }
    }
    static void PrintArray (double [] arg, String name, int columnCount) {
        for (int i = 0; i < arg.length; i++) {
            System.out.printf("%s[%3d] = %g", name, i, arg[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arg.length)
                System.out.println();
        }
    }


}
