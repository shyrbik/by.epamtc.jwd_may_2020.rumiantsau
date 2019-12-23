package by.it.akhmelev.jd01_03;


class Runner {
    public static void main(String[] args) {
        double[] result=InOut.getArray("1 2 3 6 7 8 9 0 11");
        InOut.printArray(result);
        InOut.printArray(result,"R",4);
    }
}
