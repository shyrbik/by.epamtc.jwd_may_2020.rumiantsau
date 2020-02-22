package by.it.lozouski.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_calc_TaskA {

    private Parser testParser = new Parser();

    @Before
    public void startTest() {
        System.out.println("Старт теста для задания A.\n");
    }

    @Test
    public void testScalarOperationTaskA() throws CalcException {
        String[] testArrayExpression = new String[]{"A=2+5.3", "B=A*3.5", "B1=B+0.11*-5", "B2=A/2-1"};
        Double[] testArrayResult = new Double[]{7.3, 25.55, 25.0, 2.65};
        Double[] actualArrayResult = new Double[testArrayExpression.length];
        for (int i = 0; i < testArrayExpression.length; i++) {
            Scalar scalarI = (Scalar) testParser.calculate(testArrayExpression[i]);
            double actualResultI = Double.parseDouble(scalarI.toString());
            actualArrayResult[i] = actualResultI;
        }
        for (int i = 0; i < testArrayExpression.length; i++) {
            assertEquals("Неправильный результат вычисления: " +
                                   testArrayExpression[i], testArrayResult[i], actualArrayResult[i]);
            System.out.println("Выражение: " + testArrayExpression[i] + " выполнено успешно." +
                             "\nРезультат: " + actualArrayResult[i] + '\n');
        }
    }
    
}