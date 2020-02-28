package by.it.busel.calc02_05;

@SuppressWarnings("all")
class CalcException extends Exception {
    CalcException() {
    }

    CalcException(String message) {
        super(String.format("%s ", ResourcesManager.get(Message.CALC_EXCEPTION_MESSAGE_PART)) + message);
    }

    CalcException(String message, Throwable cause) {
        super(String.format("%s ", ResourcesManager.get(Message.CALC_EXCEPTION_MESSAGE_PART)) + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }
}
