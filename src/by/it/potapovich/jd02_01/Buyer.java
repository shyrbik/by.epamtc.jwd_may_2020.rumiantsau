package by.it.potapovich.jd02_01;

public class Buyer extends Thread implements Runnable, IBuyer{
    int num;
    public Buyer (int num) {
        this.num = num;
        this.setName("Покупатель № " + num + " ");
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        try {
            int pause = Rnd.fromTo(500,2000);
            Thread.sleep(pause);
        }catch (InterruptedException e){
            System.err.println(this + "выбрал товар");
        }

    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");


    }
}
