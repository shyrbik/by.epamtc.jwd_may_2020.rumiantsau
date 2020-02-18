package by.it.potapovich.jd02_02;

import java.util.*;

public class Market {
    private static int countBuyers = 0;


    public static void main(String[] args) throws InterruptedException {
        Good toiletPaper = new Good("Туалетная бумага");
        Good cucumber = new Good("Овощи");
        Good bread = new Good("Хлеб");
        Good fruits = new Good("Фрукты");
        Good salt = new Good("Соль");
        Good sugar = new Good("Сахар");
        Good potato = new Good("Булочки");
        Good tomato = new Good("Кетчуп");
        Good cheese = new Good("Сыр");
        Good chicken = new Good("Мясо");

        Map<Good,Integer> goods = new LinkedHashMap<>();
        goods.put(toiletPaper,5);
        goods.put(cucumber,2);
        goods.put(bread,1);
        goods.put(fruits,15);
        goods.put(salt,1);
        goods.put(sugar,2);
        goods.put(potato,3);
        goods.put(tomato,2);
        goods.put(cheese,4);
        goods.put(chicken,25);
        Backet backet = new Backet();



        System.out.println("---------- Market opened");
        List<Thread> threads = new ArrayList<>(1000);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        Queue <Buyer> queue = new ArrayDeque<>();
        while (countBuyers <= 120){
            Thread.sleep(1000);
            int count = Helper.random(0,2);
            for (int i =0; i <= count; i ++){
                countBuyers++;
                if (countBuyers < 120){
                    Buyer buyer = new Buyer(countBuyers,  goods, backet);
                    queue.add(buyer);

                }
            }for (Buyer buyer: queue) {
                buyer.join();
            }
        }System.out.println("--------- Market closed");
    }

}
