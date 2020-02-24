package by.it.samuseva.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParsetTest {
    @Before
    public void start() throws Exception{
        System.out.println("Start test.");
    }

    @After
    public void stop() throws Exception{
        System.out.println("Stop test.");
    }

    @Test
    public void calcEqualsScalar() throws CalcException {
        Parset parser=new Parset();
        String expression = "A=3";
        double expected = 3.0;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect "+expression,expected,actual,1e-5);
        System.out.printf("Expected : %s \nActual   : %s \n", expected, actual);
    }

    @Test
    public void calcAddSubMulDivScalar() throws CalcException {
        Parset parser=new Parset();
        String expression = "2*2+2/2";
        double expected = 5.0;
        Scalar scalar = (Scalar) parser.calc(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals("Incorrect "+expression,expected,actual,1e-5);
        System.out.printf("Expected : %s \nActual   : %s \n", expected, actual);
    }
}