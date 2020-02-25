package by.it.lozouski.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class My_Test_Calc_Parser {

    private Parser testParser = new Parser();


    @Test(timeout = 5000)
    public void testCreateScalar() {
        try {
            Var resultActual1 = testParser.calculate("s=5.25");
            Var resultActual2 = testParser.calculate("s1=2.0");
            Var resultActual3 = testParser.calculate("s2=-10.4");
            String expected1 = "5.25";
            String expected2 = "2.0";
            String expected3 = "-10.4";
            assertEquals("Некорректный результат.", expected1, resultActual1.toString());
            System.out.println("Создание переменной: " + "s=5.25" + " выполнено успешно.\n" + "Результат:" + resultActual1.toString());
            assertEquals("Некорректный результат.", expected2, resultActual2.toString());
            System.out.println("Создание переменной: " + "s1=2.0" + " выполнено успешно.\n" + "Результат:" + resultActual2.toString());
            assertEquals("Некорректный результат.", expected3, resultActual3.toString());
            System.out.println("Создание переменной: " + "s2=-10.4" + " выполнено успешно.\n" + "Результат:" + resultActual3.toString());
        } catch (CalcException e) {
            System.out.println("Тест не пройден!!!");
            e.printStackTrace();
        }
    }

    @Test(timeout = 5000)
    public void testCreateVector() throws CalcException {
        Var resultActual4 = testParser.calculate("v={1,2,3}");
        Var resultActual5 = testParser.calculate("v1={4,-5, 6, 0}");
        Var resultActual6 = testParser.calculate("v2={-2, 10,4,225,-5}");
        String expected4 = "{1.0, 2.0, 3.0}";
        String expected5 = "{4.0, -5.0, 6.0, 0.0}";
        String expected6 = "{-2.0, 10.0, 4.0, 225.0, -5.0}";
        assertEquals("Некорректный результат.", expected4, resultActual4.toString());
        System.out.println("Создание переменной: " + "v={1,2,3}" + " выполнено успешно.\n" + "Результат:" + resultActual4.toString());
        assertEquals("Некорректный результат.", expected5, resultActual5.toString());
        System.out.println("Создание переменной: " + "v1={4,-5, 6, 0}" + " выполнено успешно.\n" + "Результат:" + resultActual5.toString());
        assertEquals("Некорректный результат.", expected6, resultActual6.toString());
        System.out.println("Создание переменной: " + "v2={-2, 10,4,225,-5}" + " выполнено успешно.\n" + "Результат:" + resultActual6.toString());
    }

    @Test(timeout = 5000)
    public void testCreateMatrix() throws CalcException {
        Var resultActual7 = testParser.calculate("m={{1,2,3},{4,5,6}}");
        Var resultActual8 = testParser.calculate("m1={{4,-5, 6, 0}, {2,3,-4,5}}");
        Var resultActual9 = testParser.calculate("m2={{-2, 10,4,225,-5},{5,4,325,1,-9}}");
        String expected7 = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}";
        String expected8 = "{{4.0, -5.0, 6.0, 0.0}, {2.0, 3.0, -4.0, 5.0}}";
        String expected9 = "{{-2.0, 10.0, 4.0, 225.0, -5.0}, {5.0, 4.0, 325.0, 1.0, -9.0}}";
        assertEquals("Некорректный результат.", expected7, resultActual7.toString());
        System.out.println("Создание переменной: " + "m={{1,2,3},{4,5,6}}" + " выполнено успешно.\n" + "Результат:" + resultActual7.toString());
        assertEquals("Некорректный результат.", expected8, resultActual8.toString());
        System.out.println("Создание переменной: " + "m1={{4,-5, 6, 0}, {2,3,-4,5}}" + " выполнено успешно.\n" + "Результат:" + resultActual8.toString());
        assertEquals("Некорректный результат.", expected9, resultActual9.toString());
        System.out.println("Создание переменной: " + "m2={{-2, 10,4,225,-5},{5,4,325,1,-9}}" + " выполнено успешно.\n" + "Результат:" + resultActual9.toString());
    }

    @Test
    public void testScalarAddScalar() throws CalcException {
        String expression = "22.45+77.55";
        double expected = 100.00;
        double actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Некорректное вычисление " + expression, expected, actual, 0.005);
        System.out.println("Для выражения " + expression + "   Результат: " + actual + "\nТЕСТ ОК!");
    }

    @Test
    public void testScalarSubScalar() throws CalcException {
        String expression = "77.55-22.45";
        double expected = 55.099;
        double actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Некорректное вычисление " + expression, expected, actual, 0.005);
        System.out.println("Для выражения: " + expression + "   Результат: " + actual + "\nТЕСТ ОК!");
    }

    @Test
    public void testScalarMulScalar() throws CalcException {
        String expression = "77.55*22.45";
        double expected = 1740.9975;
        double actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Некорректное вычисление " + expression, expected, actual, 0.005);
        System.out.println("Для выражения: " + expression + "   Результат: " + actual + "\nТЕСТ ОК!");
    }

    @Test
    public void testScalarDivScalar() throws CalcException {
        String expression = "77.55/22.45";
        double expected = 3.4543;
        double actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Некорректное вычисление " + expression, expected, actual, 0.005);
        System.out.println("Для выражения: " + expression + "   Результат: " + actual + "\nТЕСТ ОК!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorDivByZeroScalar() throws CalcException {
        String expression = "77.55/0";
        Var scalar = testParser.calculate(expression);
        System.out.println("ТЕСТ НЕ ПРОШЕЛ! Деление на ноль не произошло!\n"
                + "актуальное значение: " + expression + " Результат: " + scalar);
    }

    @Test
    public void testVectorAddVector() throws CalcException {
        String expression = "{-1,2,3}+{4,5,-6}";
        String expected = "{3.0, 7.0, -3.0}";
        String vectorActual = testParser.calculate(expression).toString();
        assertEquals("Некорректное вычисление " + expression, expected, vectorActual);
        System.out.println("Для выражения " + expression + "   Результат: " + vectorActual + "\nТЕСТ ОК!");
    }

    @Test
    public void testVectorSubVector() throws CalcException {
        String expression = "{-1,2,3}-{4,5,-6}";
        String expected = "{-5.0, -3.0, 9.0}";
        String vectorActual = testParser.calculate(expression).toString();
        assertEquals("Некорректное вычисление " + expression, expected, vectorActual);
        System.out.println("Для выражения " + expression + "   Результат: " + vectorActual + "\nТЕСТ ОК!");
    }

    @Test
    public void testVectorMulVector() throws CalcException {
        String expression = "{-1,2,3}*{4,5,-6}";
        String expected = "-12.0";
        String vectorActual = testParser.calculate(expression).toString();
        assertEquals("Некорректное вычисление " + expression, expected, vectorActual);
        System.out.println("Для выражения " + expression + "   Результат: " + vectorActual + "\nТЕСТ ОК!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorVectorDivVector() throws CalcException {
        String expression = "{-1,2,3}/{4,5,-6}";
        String vectorActual = testParser.calculate(expression).toString();
        System.out.println("ТЕСТ НЕ ПРОШЕЛ!!! ВЕКТОР НА ВЕКТОР ДЕЛИТЬ НЕЛЬЗЯ!!!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorDivByZeroVector() throws CalcException {
        String expression = "{1,2,3}/0";
        Var scalar = testParser.calculate(expression);
        System.out.println("ТЕСТ НЕ ПРОШЕЛ! Деление на ноль не произошло!\n"
                + "актуальное значение: " + expression + " Результат: " + scalar);
    }

    @Test
    public void testMatrixAddMatrix() throws CalcException {
        String expression = "{{-1,2,3},{-5,2,5}}+{{4,5,-6},{10,4,20}}";
        String expected = "{{3.0, 7.0, -3.0}, {5.0, 6.0, 25.0}}";
        String vectorActual = testParser.calculate(expression).toString();
        assertEquals("Некорректное вычисление " + expression, expected, vectorActual);
        System.out.println("Для выражения " + expression + "   Результат: " + vectorActual + "\nТЕСТ ОК!");
    }

    @Test
    public void testMatrixSubMatrix() throws CalcException {
        String expression = "{{-1,2,3},{-5,2,5}}-{{4,5,-6},{10,4,20}}";
        String expected = "{{-5.0, -3.0, 3.0}, {-15.0, -2.0, 5.0}}";
        String vectorActual = testParser.calculate(expression).toString();
        assertEquals("Некорректное вычисление " + expression, expected, vectorActual);
        System.out.println("Для выражения " + expression + "   Результат: " + vectorActual + "\nТЕСТ ОК!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorMatrixMulMatrix() throws CalcException {
        String expression = "{{-1,2,3},{-5,2,5}}*{{4,5,-6},{10,4,20}}";
        String vectorActual = testParser.calculate(expression).toString();
        System.out.println("ТЕСТ НЕ ПРОШЕЛ!!! ТАКАЯ ОПЕРАЦИЯ НЕ СУЩЕСТВУЕТ!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorMatrixDivMatrix() throws CalcException {
        String expression = "{{-1,2,3},{-5,2,5}}/{{4,5,-6},{10,4,20}}";
        String vectorActual = testParser.calculate(expression).toString();
        System.out.println("ТЕСТ НЕ ПРОШЕЛ!!! ТАКАЯ ОПЕРАЦИЯ НЕ СУЩЕСТВУЕТ!");
    }

    @Test(expected = CalcException.class, timeout = 5000)
    public void testErrorDivByZeroMatrix() throws CalcException {
        String expression = "{{1,2,3},{4,5,6}}/0";
        Var scalar = testParser.calculate(expression);
        System.out.println("ТЕСТ НЕ ПРОШЕЛ! Деление на ноль не произошло!\n"
                + "актуальное значение: " + expression + " Результат: " + scalar);
    }

    @Test
    public void testOperationsWithScalars() throws CalcException {
        String expression;
        double expected;
        double actual;

        expression = "A=2+5.3";
        expected = 7.3;
        actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Wrong "+ expression,expected,actual,0.005);
        System.out.println("TEST: " + expression + "   RESULT: " + actual + "  OK!");

        expression = "B=A*3.5";
        expected = 25.55;
        actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Wrong "+ expression,expected,actual,0.005);
        System.out.println("TEST: " + expression + "   RESULT: " + actual + "  OK!");

        expression = "B1=B+0.11*-5";
        expected = 25.00;
        actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Wrong "+ expression,expected,actual,0.005);
        System.out.println("TEST: " + expression + "   RESULT: " + actual + "  OK!");

        expression = "B2=A/2-1";
        expected = 2.65;
        actual = Double.parseDouble(testParser.calculate(expression).toString());
        assertEquals("Wrong "+ expression,expected,actual,0.005);
        System.out.println("TEST: " + expression + "   RESULT: " + actual + "  OK!");

    }

}