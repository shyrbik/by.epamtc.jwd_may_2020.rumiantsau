package by.it.kuzmichalex.calc_jd02_04;

class Printer {

    void print(Var varToPrint) {
        if (varToPrint != null)
            System.out.println(varToPrint);
        else
            System.out.println("Пустое значение для печати");
    }

}
