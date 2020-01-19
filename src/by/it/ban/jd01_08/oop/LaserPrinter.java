package by.it.ban.jd01_08.oop;

public class LaserPrinter extends Printer {
    int paperSize;

    @Override
    public int insertPaper() {
        return super.insertPaper();
    }

    @Override
    public int print() {
        return super.print();
    }

    @Override
    public int ejectPaper() {
        return super.ejectPaper();
    }

    @Override
    public int printPage(String[] lines) {
        int i=0;
        System.out.println("Печатаю страницу");
        insertPaper();
        while (i<lines.length){
            printLine(lines[i]);
            if(paperSize>0 && i%paperSize==0){
                ejectPaper();
                insertPaper();
            }
            i++;
        }
        ejectPaper();
        return 0;
    }

    @Override
    public int printLine(String line) {
        System.out.println("Печатаю строку");
        return 0;
    }

    @Override
    public int setPaperSize(int lines) {
        this.paperSize=lines;
        return 0;
    }

    @Override
    public int getState() {
        return super.getState();
    }
}
