package by.it.kuzmichalex.jd01_03;

public class Runner {
    public static void main(String[] args) {
        double[] Arr= InOut.getArray("             1 22 333 444.1 5.2 6 77 343 4546 567 5675 67");
        InOut.printArray(Arr);
        InOut.printArray(Arr,"Arr",5);
    }
}
