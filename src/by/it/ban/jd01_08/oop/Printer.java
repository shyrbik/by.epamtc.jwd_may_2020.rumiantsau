package by.it.ban.jd01_08.oop;

public abstract class Printer implements Output {
    @Override
    public int insertPaper() {
        System.out.println("Взяли бумагу из лотка");
        return 0;
    }

    @Override
    public int print() {
        return 0;
    }

    @Override
    public int ejectPaper() {
        System.out.println("Выплюнули бумагу в исходящий лоток");
        return 0;
    }

    @Override
    public int printPage(String[] lines) {
        System.out.println("Вывожу страницу на печать");
        return 0;
    }

    @Override
    public int printLine(String line) {
        System.out.println("Выводу на печать строку");
        return 0;
    }

    @Override
    public int setPaperSize(int lines) {
        System.out.println("Устанавливаю длину страницы в строках");
        return 0;
    }

    @Override
    public int getState() {
        System.out.println("Возвращаю состояние принтера");
        return 0;
    }
}

