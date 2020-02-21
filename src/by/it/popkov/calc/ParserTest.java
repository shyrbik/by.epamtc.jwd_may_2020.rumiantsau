package by.it.popkov.calc;

import org.junit.*;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser = new Parser();

    @Test
    public void a1() {
        try {
            Var calc = parser.calc("A=2+5.3");
            assertEquals("Wrong result for A=2+5.3", "7.3", calc.toString());
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a2() {
        try {
            Var calc = parser.calc("B=A*3.5");
            assertEquals("Wrong result for B=A*3.5", "25.55", calc.toString());
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a3() {
        try {
            Var calc = parser.calc("B1=B+0.11*-5");
            assertEquals("Wrong result for B1=B+0.11*-5", "25.0", calc.toString());
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a4() {
        try {
            Var calc = parser.calc("B2=A/2-1");
            assertEquals("Wrong result for B2=A/2-1", "2.65", calc.toString());
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }
}