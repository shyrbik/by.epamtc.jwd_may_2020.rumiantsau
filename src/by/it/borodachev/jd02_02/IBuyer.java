package by.it.borodachev.jd02_02;

import java.util.Comparator;

interface IBuyer extends Comparator<IBuyer> {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void add2Queue() ;        //в очередь к кассиру
    void pay(); // оплатить
    void goOut();            //отправился на выход(мгновенно)

}
