package by.it.kuzmichalex.jd02_02;

import java.util.*;

public class CashierManager {
    //private static Map<Cashier, Thread> mapCashiers = new HashMap<>();
    private static List<Cashier> listCashiers = new ArrayList<>();
    private static List<Thread> listThreads = new ArrayList<>();

    CashierManager() {
        //Менеджер мейкинг дэйли аджайл митинг
        for (int i = 0; i < Dispatcher.MAX_CASHIERS; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            listCashiers.add(cashier);
            listThreads.add(thread);
            //mapCashiers.put(cashier, thread);
            thread.start();
        }
    }

    /**
     * Управление всем этим колхозом.
     */
    void doManaging(String reason) {
        int cashiersNeed = (BuyerQueue.getQueueSize() / 5);
        //System.out.println("cashiersNeed " + cashiersNeed);
        for (int idx = 0; idx < Dispatcher.MAX_CASHIERS; idx++) {
            if (idx > cashiersNeed) listCashiers.get(idx).goWait("Manager");
            else {if (listThreads.get(idx).getState() == Thread.State.WAITING) listCashiers.get(idx).goNotify();}
        }
       /* Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            Map.Entry<Cashier, Thread> next = iterator.next();
            if (idx > cashiersNeed) next.getKey().goWait("Manager");
            else if (next.getValue().getState() == Thread.State.WAITING) next.getKey().goNotify();
            idx++;
        }*/
    }

    /**
     * Подъём всех кассиров для свеоки кассы
     */
    void stopManaging() {
        for (int idx = 0; idx < Dispatcher.MAX_CASHIERS; idx++) {
            //Всех кассиров вернём из курилок, чтобы завершили кассы
            if (listThreads.get(idx).getState() == Thread.State.WAITING) listCashiers.get(idx).goNotify();
            //присоединимся ко всем процессам и дождёся их завершения
            try {
                listThreads.get(idx).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

      /*  Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
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
        }*/
        listThreads.clear();
        listCashiers.clear();
        //   mapCashiers.clear();
        Logger.addToLog(" ", 0);
        Logger.addToLog(" ", 0);
        //System.out.println("Manager Done");
    }
}
