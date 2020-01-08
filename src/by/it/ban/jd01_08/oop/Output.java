package by.it.ban.jd01_08.oop;

interface Output {
    int insertPaper();
    int print();
    int ejectPaper();
    int printPage(String[] lines);
    int printLine(String line);
    int setPaperSize(int lines);
    int getState();
}
