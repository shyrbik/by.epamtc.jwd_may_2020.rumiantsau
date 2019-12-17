package by.it.popkov.jd01_04;

class InOut {
    static double[] getArray(String line) {
        String[] s = line.trim().split(" ");
        double[] outPut = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            outPut[i] = Double.parseDouble(s[i]);
        }
        return outPut;
    }

    static void printArray(double[] result) {
        for (double v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] result, String name, int num) {
        System.out.println(name);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s[%d]=%-4f ", name, i, result[i]);
            if ((i + 1) % num == 0) System.out.println();
        }
        System.out.println();
    }

}


