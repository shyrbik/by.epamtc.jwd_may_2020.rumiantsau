package by.it.popkov.jd01_08.oop;

class Tanker extends CargoShip {
    Tanker(String name) {
        super(name);
    }

    Tanker() {
        this("No Name");
    }

    @Override
    public void sail() {
        System.out.print("Tanker " + getName() + " ");
        super.sail();
    }

    @Override
    public void moor() {
        System.out.print("Tanker " + getName() + " ");
        super.moor();
    }

    @Override
    public void dropAnchor() {
        System.out.print("Tanker " + getName() + " ");
        super.dropAnchor();
    }

    @Override
    public void sos() {
        System.out.print("Tanker " + getName() + " ");
        super.sos();
    }

    @Override
    public void stop() {
        System.out.print("Tanker " + getName() + " ");
        super.stop();
    }

    @Override
    public void load() {
        System.out.print("Tanker " + getName() + " ");
        super.load();
    }

    @Override
    public void unload() {
        System.out.print("Tanker " + getName() + " ");
        super.unload();
    }

    public void connectToOilTerminal() {
        System.out.println("Tanker " + getName() + " Connect To Oil Terminal");
    }

    @Override
    public String toString() {
        System.out.print("Great Tanker ");
        return super.toString();
    }
}
