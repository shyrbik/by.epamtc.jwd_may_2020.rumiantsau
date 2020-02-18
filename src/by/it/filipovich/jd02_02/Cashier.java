package by.it.filipovich.jd02_02;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number){
        name = "CAshier # "+number+" ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this+" opened");
        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = QueueBuyer.extract();
            if(buyer!=null){
                System.out.println(this+" started service for "+buyer);
                //timeout
                //sleep(timeout)

                System.out.println(this+" finished  service for "+ buyer);
            }
            //sleep
        }
        System.out.println(this+" closed");
    }
}
