package by.it.shpakovskiy.jd02_02;

public class Manager implements Runnable {
    private BulbaStore store;
    private boolean endWork;

    Manager(BulbaStore store) {
        this.store = store;
        Thread thread = new Thread(this, "Manager");
        thread.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!endWork) {
            Helper.sleep(1);
            store.checkForCashiers(this);
            if (store.isClosedStore()) {
                store.freePersonal(this);
                break;
            }
        }
        if (ShopRunner.IN_A_TABLE){
            String s = "│ Total buyers count: " + String.format("%4d", store.getTotalBuyersCount()) +
                    ". Total revenue: $" + String.format("%6.2f", store.getRevenue()) + "." +
                    " ".repeat(116) + "│\n" +
                    "└" + "─".repeat(167) + "┘";
            System.out.println(s);
        }
        System.out.println("########################## BulbaStore closed! Buy! ##########################");
    }

    void endOfWorkingDay() {
        endWork = true;
    }
}
