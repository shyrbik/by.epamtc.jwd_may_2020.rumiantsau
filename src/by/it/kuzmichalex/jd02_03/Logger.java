package by.it.kuzmichalex.jd02_03;


import java.util.concurrent.atomic.AtomicReferenceArray;

class Logger {
    private static final int MAX_WIDTH = 27;
    private static final int MAX_COLUMNS = Dispatcher.MAX_CASHIERS + 2;
    private static AtomicReferenceArray<String> arrLogs = new AtomicReferenceArray<>(MAX_COLUMNS);

    /**
     * Добавление в лог
     */
    static void addToLog(String text, int number) {
        if (arrLogs.get(number) != null) {
            printAndFlush();
        }
        arrLogs.set(number, text);
    }

    static void printAndFlush() {
        //    System.out.println("-------------------------------------------------------------------------------");
        //Заполним 6-7 колонку данными по очереди и тому подобному
        arrLogs.set(Dispatcher.MAX_CASHIERS, String.format("In Queue:  %3d\nIn Market: %3d", BuyerQueue.getQueueSize(), Dispatcher.getBuyersInMarket()));

        arrLogs.set(Dispatcher.MAX_CASHIERS + 1, String.format("Total amount: %7d\nCashiers working: %2d",
                Dispatcher.getMarketTotalAmount(),
                CashierManager.getCountCashiersWorks()));

        int countOfStrings = 0;
        String[][] tmp = new String[MAX_COLUMNS][10];
        for (int x = 0; x < MAX_COLUMNS; x++) {
            if (arrLogs.get(x) != null) {
                String[] splitted = arrLogs.get(x).split("\n");
                countOfStrings = Math.max(splitted.length, countOfStrings);
                System.arraycopy(splitted, 0, tmp[x], 0, splitted.length);
                arrLogs.set(x, null);  //Зачищаем
            } else if (x < Dispatcher.MAX_CASHIERS) {
                //В логе кассира X пусто. Значит, занят он обслуживает клиента sleep() или выключен wait()
                // засунем туда статус процесса. Для интереса.
                tmp[x][0] = CashierManager.getCashierState(x);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < countOfStrings; y++) {
            //sb.append(y==0?String.format("%4d|",countItemsLogged):"    |");
            for (int x = 0; x < MAX_COLUMNS; x++) {
                if (tmp[x][y] == null) sb.append(String.format("%-" + MAX_WIDTH + "s", " ")).append("|");
                else sb.append(String.format("%-" + MAX_WIDTH + "s", tmp[x][y])).append("|");
                tmp[x][y] = null;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
