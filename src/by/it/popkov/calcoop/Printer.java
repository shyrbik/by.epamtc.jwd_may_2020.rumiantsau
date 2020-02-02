package by.it.popkov.calcoop;

class Printer  {
    public void print (Var calc) throws CalcException {
        if (calc != null){
            System.out.println(calc.toString());
        }else {
            System.out.println("Error");
        }

    }
}
