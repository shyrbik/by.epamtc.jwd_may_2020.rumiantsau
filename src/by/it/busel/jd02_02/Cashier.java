package by.it.busel.jd02_02;

public class Cashier extends Thread {
    private String name;

    Cashier(int id) {
        this.name = "Cashier №" + id + " ";
    }


}
