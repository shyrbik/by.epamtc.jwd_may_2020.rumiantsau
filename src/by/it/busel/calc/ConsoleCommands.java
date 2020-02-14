package by.it.busel.calc;

//TODO add JavaDoc
class ConsoleCommands {
    private static final String PRINTVAR = "PRINTVAR";
    private static final String SORTVAR = "SORTVAR";

    public static boolean call(String varExpression) {
        if (varExpression.toUpperCase().equals(ConsoleCommands.PRINTVAR)) {
            Storage.printvar();
        } else if (varExpression.toUpperCase().equals(ConsoleCommands.SORTVAR)) {
            Storage.sortvar();
        } else return false;
        return true;
    }
}
