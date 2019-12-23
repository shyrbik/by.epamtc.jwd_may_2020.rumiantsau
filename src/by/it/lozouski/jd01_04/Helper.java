package by.it.lozouski.jd01_04;

class Helper {
    static void sort(double[] arr, int first, int last) {
        if (arr.length == 0) return;
        if (first >= last) return;
        int i = first;
        int j = last;
        int oporaElement = (int) arr[(i + j) / 2];
        do {
            while (arr[i] < oporaElement) i++;
            while (arr[j] > oporaElement) j--;
            if (i <= j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (first < j) sort(arr, first, j);
        if (i < last) sort(arr, i, last);
    }
}
