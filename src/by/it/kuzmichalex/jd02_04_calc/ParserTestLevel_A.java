package by.it.kuzmichalex.jd02_04_calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestLevel_A {

    @Test
    public void testParseScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "-123.45";
        double expected = -123.45;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }
    @Test
    public void testPutScalarToVar() throws CalcException {
        Parser parser = new Parser();
        String expression = "testvar=1234.5";
        double expected = 1234.5;
        double actual;

        Scalar scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);

        scalar = (Scalar) parser.calc("testvar");
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }

    @Test
    public void testScalarPlus() throws CalcException {
        Parser parser = new Parser();
        String expression = "123.45+111.11";
        double expected = 234.56;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }

    @Test
    public void testScalarMinus() throws CalcException {
        Parser parser = new Parser();
        String expression = "123.45-111.11";
        double expected = 12.34;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }
    @Test
    public void testScalarMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "1234321*2";
        double expected = 2468642;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }
    @Test
    public void testScalarDiv() throws CalcException {
        Parser parser = new Parser();
        String expression = "144/12";
        double expected = 12;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }

    @Test(expected = CalcException.class)
    public void testScalarDivByZero() throws CalcException {
        Parser parser = new Parser();
        String expression = "1234321*/0";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test
    public void testScalarLongExpression() throws CalcException {
        Parser parser = new Parser();
        String expression = "1+1/2+3";
        double expected = 4.5;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }
    @Test
    public void testScalarBrackets() throws CalcException {
        Parser parser = new Parser();
        String expression = "((1+1/2)+-0.5)/0.1";
        double expected = 10;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);
    }
    @Test
    public void testExpressionsWitchVars() throws CalcException {
        Parser parser = new Parser();
        String expression = "a=2+5.3";
        double expected = 7.3;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);

        expression = "b=a*3.5";
        expected = 25.55;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);

        expression = "b1=b+0.11*-5";
        expected = 25;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);

        expression = "b2=a/2-1";
        expected = 2.65;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect " + expression, expected, actual, 1e-5);


    }
}