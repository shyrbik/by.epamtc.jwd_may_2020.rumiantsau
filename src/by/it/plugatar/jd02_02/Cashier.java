package by.it.plugatar.jd02_02;

import by.it.ban.jd01_03.Helper;
import by.it.samuseva.jd01_13.Help;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number){
        name="Cashier #"+number+ " ";
    }

    @Override
        public void run(){
        while (!Dispatcher.marketClosed()){
            Buyer buyer= QueueBuyer.extract();
            if (buyer!=null){
                System.out.println(this+"started service "+buyer);
                int timeout = RandomHelper.random(2000,5000);
                RandomHelper.sleep(timeout);
            }
        }
    }


}
