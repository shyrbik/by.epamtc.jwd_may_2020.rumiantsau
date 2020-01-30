package by.it.popkov.jd01_13;

class UseFull {
    static void printException(RuntimeException e) {
        String name = e.getClass().getName();
        String className = "";
        int rowNum = 0;
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(TaskA.class.getName())) {
                className = stackTraceElement.getClassName();
                rowNum = stackTraceElement.getLineNumber();
            }
        }
        System.out.printf(" name: %s\nclass: %s\n line: %d", name, className, rowNum);
    }
}
