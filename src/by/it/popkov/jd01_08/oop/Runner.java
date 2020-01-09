package by.it.popkov.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        Ship powerFull = new Tanker("Power Full");
        powerFull.sail();
        System.out.println(powerFull);
        ((Tanker) powerFull).connectToOilTerminal();
        ((Tanker) powerFull).disconnectFromOilTerminal();
        System.out.println();
        Ship bigBoy = new ConShip("BIG BOY");
        bigBoy.sail();
        bigBoy.stop();
        bigBoy.moor();
        ((ConShip) bigBoy).unload(10);
        ((ConShip)bigBoy).load(10);
    }
}
