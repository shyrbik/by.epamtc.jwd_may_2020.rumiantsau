package by.it.busel.jd01_04;

public class TaskC {
    static void buildOneDimArray(String line) {
        double[] arrayOfDoubles = InOut.getArray(line);
        InOut.printArray(arrayOfDoubles, "V", 5);
        double firstElement = arrayOfDoubles[0];
        double lastElement = arrayOfDoubles[arrayOfDoubles.length - 1];
        mergeSort(arrayOfDoubles);
        InOut.printArray(arrayOfDoubles, "V", 4);
        System.out.printf("Index of first element=%d%n", binarySearch(arrayOfDoubles, firstElement));
        System.out.printf("Index of last element=%d%n", binarySearch(arrayOfDoubles, lastElement));
    }

    static void mergeSort(double[] arrayOfInts) {
        int left = 0, right = arrayOfInts.length - 1;
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            merge(arrayOfInts, left, middle, right);
        }
    }

    private static void mergeSort(double[] arrayOfInts, int left, int right) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            merge(arrayOfInts, left, middle, right);
        }
    }

    private static void merge(double[] arrayOfInts, int left, int middle, int right) {
        mergeSort(arrayOfInts, left, middle);
        mergeSort(arrayOfInts, middle + 1, right);
        double[] copy = new double[middle - left + 1];
        for (int x = 0, filler = left; x < copy.length; x++, filler++) {
            copy[x] = arrayOfInts[filler];
        }

        for (int i = left, indexCopy = 0, j = middle + 1; i <= right; i++) {
            if (indexCopy < copy.length && j <= right) {
                if (copy[indexCopy] <= arrayOfInts[j]) {
                    arrayOfInts[i] = copy[indexCopy];
                    indexCopy++;
                } else if (copy[indexCopy] > arrayOfInts[j]) {
                    arrayOfInts[i] = arrayOfInts[j];
                    j++;
                }
            } else if (indexCopy < copy.length) {
                arrayOfInts[i] = copy[indexCopy];
                indexCopy++;
            } else {
                break;
            }
        }
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (value == array[middle]) {
                return middle;
            } else if (value < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        buildOneDimArray("10 9 8 7 6 5 4");
    }
}
