package by.it.popkov.jd01_08.oop;

class ConShip extends CargoShip {
    ConShip(String name) {
        super(name);
    }

    @Override
    public void sail() {
        super.sail();
    }

    @Override
    public void moor() {
        super.moor();
    }

    @Override
    public void dropAnchor() {
        super.dropAnchor();
    }

    @Override
    public void sos() {
        super.sos();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void load() {
        System.out.print("Containers ");
        super.load();
    }

    public void load(int num) {
        System.out.print("Container # " + num + " ");
        super.load();
    }

    @Override
    public void unload() {
        System.out.print("Containers ");
        super.unload();
    }

    public void unload(int num) {
        System.out.print("Container # " + num + " ");
        super.unload();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "СonShip " + super.toString();
    }
}
