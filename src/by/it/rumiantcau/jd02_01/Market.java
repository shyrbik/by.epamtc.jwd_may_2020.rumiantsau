package by.it.rumiantcau.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static List<Buyer> buyers=new ArrayList<>(1000);
    public static void main(String[] args) {
        System.out.println("####Открытие магазина####");
        int number=0;

        for (int time = 0; time <= 120; time++) {
            int count= Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("Неизвестная ошибка с покупателями");
            }
        }


        System.out.println("####Закрытие магазина####");


 }


}
