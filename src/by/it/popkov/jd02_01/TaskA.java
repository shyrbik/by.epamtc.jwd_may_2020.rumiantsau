package by.it.popkov.jd02_01;

class TaskA {
    public static void main(String[] args) {
        Buyer buyer = new Buyer(1);
        buyer.start();
        System.out.println("end of main");
    }
}
