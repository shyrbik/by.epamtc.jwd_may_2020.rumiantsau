package by.it.Plugatar.jd01_01;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // System.out.println("Hello WORLD!");
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Прывет");
        hello.printSlogan();

        Args argObject = new Args(args);
        //((Args) argObject).printArgs();
        argObject.printArgs();
    }
}
