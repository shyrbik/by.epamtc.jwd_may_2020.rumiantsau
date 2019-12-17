package by.it.popkov.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
//        double[] array = new double[]{-4.862193087624437, -11.937181707301974, -2.397721846682014, 13.043459411607767, -6.518182401196068, 1.0713582211089907, 15.370559559002995, -10.86830209466446, -9.7837386533957, -13.07642449578424, 7.168261986827282, 15.393028193054153, -14.416765213920826, 13.951851738811726, -11.920261051895066};
//        System.out.println(Arrays.toString(mergeSor(array)));
//        double [] array = new double[]{-4.862193087624437, -11.937181707301974, -2.397721846682014, 13.043459411607767, -6.518182401196068, 1.0713582211089907, 15.370559559002995, -10.86830209466446, -9.7837386533957, -13.07642449578424, 7.168261986827282, 15.393028193054153, -14.416765213920826, 13.951851738811726, -11.920261051895066};
//        TaskC.mergeSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(TaskC.merge(new double[]{8, 9, 11}, new double[]{3, 4, 5, 9})));
        buildOneDimArray("2 4 25 3 6 42");
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        TaskC.mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.printf("Index of first element=%d\n", binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", binarySearch(array, last));


    }

    static void mergeSort(double[] array) {
//????????????????????        array = mergeSor(array);
        double[] a = mergeSor(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }


    private static double[] mergeSor(double[] array) {
        if (array.length < 2) return array;
        double[] left = new double[array.length / 2];
        double[] right = new double[array.length - array.length / 2];
        for (int i = 0; i < array.length / 2; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < array.length - array.length / 2; i++) {
            right[i] = array[i + array.length / 2];
        }
        left = mergeSor(left);
        right = mergeSor(right);
        return merge(left, right);
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] outPut = new double[part1.length + part2.length];
        for (int i = 0, one = 0, two = 0; i < outPut.length; i++) {
            if (one == part1.length) {
                for (; two < part2.length; two++, i++) {
                    outPut[i] = part2[two];
                }
                break;
            }
            if (two == part2.length) {
                for (; one < part1.length; one++, i++) {
                    outPut[i] = part1[one];
                }
                break;
            }
            if (part1[one] <= part2[two]) {
                outPut[i] = part1[one];
                one++;
            } else if (part1[one] >= part2[two]) {
                outPut[i] = part2[two];
                two++;
            }
        }
        return outPut;
    }


    static int binarySearch(double[] array, double value) {

//        double m = array[array.length/2];
//        if (m == value){
//            return array.length/2;
//        }else if(value<m){
//            double[] left = new double[array.length/2];
//            for (int i = 0; i < left.length; i++) {
//                left[i] = array[i];
//            }
//            return binarySearch(left, value);
//        }else if (value>m){
//            double[] right = new double[array.length - array.length/2];
//            for (int i = 0; i < right.length; i++) {
//                right[i] = array[array.length/2 + i];
//            }
//            return binarySearch(right, value);
//        }else return -1;

        int left = 0;
        int right = array.length;

        for (; ; ) {
            int m = left + (right - left) / 2;

            if (array[m] == value) {
                return m;
            }


            if (array[m] > value) {
                right = m;
            } else if (array[m] < value) {
                left = m + 1;
            }


        }

    }
}
