package by.it.lozouski.calc;

class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(Error.ERR + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Error.ERR + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
