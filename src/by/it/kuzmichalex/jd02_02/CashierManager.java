package by.it.kuzmichalex.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CashierManager {
    private static Map<Cashier, Thread> mapCashiers = new HashMap<>();

    CashierManager() {
        //System.out.println("Manager comes to work");
        //Менеджер мейкинг дэйли аджайл митинг
        mapCashiers.clear();
        for (int i = 0; i < Dispatcher.MAX_CASHIERS; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            mapCashiers.put(cashier, thread);
            thread.start();
        }
    }

    /**
     * Управление всем этим колхозом.
     */
    void doManaging(String reason) {
        int cashiersNeed = (BuyerQueue.getQueueSize() / 5);
        //System.out.println("managing " + reason + " need cashiers:" + cashiersNeed + "cashiers:" + mapCashiers.size());

        Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            Map.Entry<Cashier, Thread> next = iterator.next();
            if (idx > cashiersNeed) next.getKey().goWait("Manager");
            else if (next.getValue().getState() == Thread.State.WAITING) next.getKey().goNotify();
            idx++;
        }
    }

    /**
     * Подъём всех кассиров для свеоки кассы
     */
    void stopManaging() {
        Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
        //System.out.println("Manager stopping...");
        while (iterator.hasNext()) {
            Map.Entry<Cashier, Thread> next = iterator.next();
            if (next.getValue().getState() == Thread.State.WAITING) next.getKey().goNotify();
            //Всех кассиров вернули из курилок, чтобы завершили кассы
            //присоединимся ко всем процессам и дождёся их завершения
            try {
                next.getValue().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mapCashiers.clear();
        Logger.addToLog(" ",0);
        Logger.addToLog(" ",0);
        //System.out.println("Manager Done");
    }
}
