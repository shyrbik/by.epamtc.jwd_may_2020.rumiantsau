package by.it.samuseva.jd02_02;

import java.util.ArrayDeque;

class CashierManager extends Thread{
    private static ArrayDeque<Thread> cashiers = new ArrayDeque<>(Dispetcher.getCountCashier());

    @Override
    public void run() {
        for (int i = 0; i < Dispetcher.getCountCashier(); i++) {
            Cashier cashier = new Cashier(++i);
            Thread thread = new Thread(cashier);
            thread.start();
            cashiers.add(thread);
        }
        System.out.println("*"+this.getName() + this.getState());
        for (Thread cashier : cashiers) {
            System.err.println(cashier.getName() +" "+ cashier.getState());
       //     cashier.notify();
            System.err.println(cashier.getName() +" "+ cashier.getState());


//            Thread thread = cashier;
//            System.err.println(thread.getName() +" "+ thread.getState());
//            run(thread);
//            System.err.println(thread.getName() + thread.getState());
        }





        for (Thread  cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.err.println("YPS !!!");
            }
        }

    }

    synchronized void run(Thread thread) {
        thread.notify();
    }
}
