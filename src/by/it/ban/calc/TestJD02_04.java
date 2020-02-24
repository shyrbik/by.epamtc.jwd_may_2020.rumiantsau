package by.it.ban.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestJD02_04 {

    @Test
    public void TestA() throws Exception {
        Parser parser=new Parser();
        String expression = "A=2+5.3";
        double expected=7.3;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Ошибка "+expression,expected,actual,1e-5);

        expression = "B=A*3.5";
        expected=25.55;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Ошибка "+expression,expected,actual,1e-5);

        expression = "B1=B+0.11*-5";
        expected=25;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Ошибка "+expression,expected,actual,1e-5);

        expression = "B2=A/2-1";
        expected=2.65;
        scalar = (Scalar) parser.calc(expression);
        actual = Double.parseDouble(scalar.toString());
        assertEquals("Ошибка "+expression,expected,actual,1e-5);
    }

}
