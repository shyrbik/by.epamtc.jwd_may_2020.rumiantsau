package by.it.samuseva.jd02_01;

class Helper {
    static void sleep (int terminat){
        try {
            Thread.sleep(terminat);
        } catch (InterruptedException e) {
            System.err.println("YPS !!!");
        }

    }
}
