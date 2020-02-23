package by.it.popkov.calc;

import org.junit.*;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser = new Parser();

    /**
     * TEST SCALAR
     **/

    @Test
    public void a1() {
        System.out.println("Test A=2+5.3");
        try {
            Var calc = parser.calc("A=2+5.3");
            assertEquals("Wrong result for A=2+5.3", "7.3", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a2() {
        System.out.println("Test B=A*3.5");
        try {
            Var calc = parser.calc("B=A*3.5");
            assertEquals("Wrong result for B=A*3.5", "25.55", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a3() {
        System.out.println("Test B1=B+0.11*-5");
        try {
            Var calc = parser.calc("B1=B+0.11*-5");
            assertEquals("Wrong result for B1=B+0.11*-5", "25.0", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a4() {
        System.out.println("Test B2=A/2-1");
        try {
            Var calc = parser.calc("B2=A/2-1");
            assertEquals("Wrong result for B2=A/2-1", "2.65", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST VECTOR
     **/
    @Test
    public void vectorAddScalar() {
        System.out.println("Test {2, 3} + 2");
        try {
            Var calc = parser.calc("{2, 3} + 2");
            assertEquals("Wrong result for {2, 3} + 2", "{4.0, 5.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorAddVector() {
        System.out.println("Test {0, 1}+{2, 3}");
        try {
            Var calc = parser.calc("{0, 1}+{2, 3}");
            assertEquals("Wrong result for {0, 1}+{2, 3}", "{2.0, 4.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorSubScalar() {
        System.out.println("Test {2, 3} - 2");
        try {
            Var calc = parser.calc("{2, 3} - 2");
            assertEquals("Wrong result for {2, 3} - 2", "{0.0, 1.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorSubVector() {
        System.out.println("Test {0, 1} - {2, 3}");
        try {
            Var calc = parser.calc("{0, 1} - {2, 3}");
            assertEquals("Wrong result for {0, 1} - {2, 3}", "{-2.0, -2.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulScalar() {
        System.out.println("Test {{0, 1}, {2, 3}} * 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * 3", "{{0.0, 3.0}, {6.0, 9.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulVector() {
        System.out.println("Test {0, 1} * {2, 3}");
        try {
            Var calc = parser.calc("{0, 1} * {2, 3}");
            assertEquals("Wrong result for {0, 1} * {2, 3}", "3.0", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulMatrix() {
        System.out.println("Test {2,6} * {{0, 1}, {2, 3}}");
        try {
            Var calc = parser.calc("{2,6} * {{0, 1}, {2, 3}}");
            assertEquals("Wrong result for {2,6} * {{0, 1}, {2, 3}}", "{6.0, 22.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorDivScalar() {
        System.out.println("Test {2, 3} / 2");
        try {
            Var calc = parser.calc("{2, 3} / 2");
            assertEquals("Wrong result for {2, 3} / 2", "{1.0, 1.5}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }


    /**
     * TEST MATRIX
     **/

    @Test
    public void matrixAddScalar() {
        System.out.println("Test {{0, 1}, {2, 3}} + 2");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} + 2");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} + 2", "{{2.0, 3.0}, {4.0, 5.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixAddMatrix() {
        System.out.println("Test {{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}",
                    "{{4.0, 6.0}, {8.0, 13.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixSubScalar() {
        System.out.println("Test {{0, 1}, {2, 3}} - 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} - 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} - 3",
                    "{{-3.0, -2.0}, {-1.0, 0.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixSubMatrix() {
        System.out.println("Test {{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}",
                    "{{4.0, -4.0}, {-4.0, 13.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulScalar() {
        System.out.println("Test {{0, 1}, {2, 3}} * 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * 3",
                    "{{0.0, 3.0}, {6.0, 9.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulVector() {
        System.out.println("Test {{0, 1}, {2, 3}} * {-4, 5}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * {-4, 5}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * {-4, 5}",
                    "{5.0, 7.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulMatrix() {
        System.out.println("Test {{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}",
                    "{{6.0, -10.0}, {10.0, -20.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixDivScalar() {
        System.out.println("Test {{0, 1}, {2, 3}} / 2.0");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} / 2.0");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} / 2.0",
                    "{{0.0, 0.5}, {1.0, 1.5}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST VARIABLE
     **/

    @Test
    public void varScalar() {
        fail();
        System.out.println("Test variable Scalar");
        try {
            Var calc = parser.calc("A=1.5");
            assertEquals("Wrong result for A=1.5", "1.5", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void varVector() {
        fail();
        System.out.println("Test variable B={1.5, 2.3}");
        try {
            Var calc = parser.calc("B={1.5, 2.3}");
            Var var = parser.calc("B");
            assertEquals("Wrong result for B={1.5, 2.3}", "{1.5, 2.3}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void varMatrix() {
        fail();
        System.out.println("Test variable A=1.5");
        try {
            Var calc = parser.calc("Test variable A=1.5");
            assertEquals("Wrong result for A=2+5.3", "7.3", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

}