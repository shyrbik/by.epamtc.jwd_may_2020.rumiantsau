package by.it.kuzmichalex.calc_jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestIncorrectExpr {

    @Test(expected = CalcException.class)
    public void testDivisionByZero() throws CalcException {
        Parser parser = new Parser();
        String expression = "123/0";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testWrongNewVarName() throws CalcException {
        Parser parser = new Parser();
        String expression = "end=5";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testUndefinedVar() throws CalcException {
        Parser parser = new Parser();
        String expression = "5+some_undefined_var_asdf";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testWrongOperation() throws CalcException {
        Parser parser = new Parser();
        String expression = "привет";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testMissedOperand() throws CalcException {
        Parser parser = new Parser();
        String expression = "5+";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testMissedOpenBracket() throws CalcException {
        Parser parser = new Parser();
        String expression = "(2+3)/3)";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testMissedCloseBracket() throws CalcException {
        Parser parser = new Parser();
        String expression = "((2+3)/3";
        Scalar scalar = (Scalar) parser.calc(expression);
    }


    @Test(expected = CalcException.class)
    public void testWrongVectorDefine() throws CalcException {
        Parser parser = new Parser();
        String expression = "{234324, 34443 ";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testWrongVectorSizeAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3,4,5}+{1,2,3}";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testWrongVectorSizeMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3,4,5}*{1,2,3}";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testDivisionByVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3,4,5}/{1,2,3}";
        Scalar scalar = (Scalar) parser.calc(expression);
    }

    @Test(expected = CalcException.class)
    public void testDivisionByMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3,4,5}/{{1,2,3},{1,2,3}}";
        Scalar scalar = (Scalar) parser.calc(expression);
    }


}