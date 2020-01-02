package by.it.popkov.jd01_08.oop;

class Tanker extends CargoShip {
    Tanker(String name) {
        super(name);
    }

    @Override
    public void sail() {
        System.out.print(getName() + " ");
        super.sail();
    }

    @Override
    public void moor() {
        System.out.print(getName() + " ");
        super.moor();
    }

    @Override
    public void dropAnchor() {
        System.out.print(getName() + " ");
        super.dropAnchor();
    }

    @Override
    public void sos() {
        System.out.print(getName() + " ");
        super.sos();
    }

    @Override
    public void stop() {
        System.out.print(getName() + " ");
        super.stop();
    }

    @Override
    public void load() {
        System.out.print(getName() + " ");
        super.load();
    }

    @Override
    public void unload() {
        System.out.print(getName() + " ");
        super.unload();
    }

    @Override
    public String toString() {
        System.out.print("Great Tanker ");
        return super.toString();
    }
}
