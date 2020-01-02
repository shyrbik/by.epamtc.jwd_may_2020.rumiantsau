package by.it.popkov.jd01_08.oop;

abstract class cargoShip implements Ship {
    private String name;

    public cargoShip(String name) {
        this.name = name;
    }

    @Override
    public void sail() {
        System.out.println("Sail");
    }

    @Override
    public void moor() {
        System.out.println("Moor");
    }

    @Override
    public void dropAnchor() {
        System.out.println("Drop Anchor");
    }

    @Override
    public void sos() {
        System.out.println("SOS");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public void load() {
        System.out.println("Load");
    }

    @Override
    public void unload() {
        System.out.println("Unload");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
