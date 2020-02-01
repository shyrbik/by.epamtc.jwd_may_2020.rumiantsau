package by.it.lozouski.jd01_13;

class Exceptions {
    static void printException(RuntimeException e, Object a) {
        String nameException = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();

        for (StackTraceElement stackTraceElement : stackTrace) {
            String classNameException = stackTraceElement.getClassName();
            int lineNumberException = stackTraceElement.getLineNumber();
            String currentClassName = a.getClass().getName();
            if (currentClassName.equals(classNameException)) {
                System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n", nameException, classNameException, lineNumberException);
            }
        }
    }
}
