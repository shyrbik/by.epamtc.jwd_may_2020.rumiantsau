package by.it.borodachev.jd02_02;

import java.util.PriorityQueue;

class Dispatcher {

    static final int K_SPEED=10000;
    static int countBuyer=0;
    static final Integer sunc=0;
    static PriorityQueue<IBuyer> buyer2Cash;
    static synchronized  void buyerIN() {countBuyer++;}
    static synchronized  void buyerOUT() {countBuyer--;}
    static synchronized  int buyerCount() {return countBuyer;}

}
