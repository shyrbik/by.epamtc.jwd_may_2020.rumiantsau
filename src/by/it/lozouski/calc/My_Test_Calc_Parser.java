package by.it.lozouski.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class My_Test_Calc_Parser {

    private Parser testParser = new Parser();

    @Before
    public void startTest() {
        System.out.println("Старт теста для задания.\n");
    }

    @Test
    public void testScalarOperation() {
            String[] testArrayExpressionScalar = new String[]{"A=2+5.3", "B=A*3.5", "B1=B+0.11*-5", "B2=A/2-1"};
            Double[] testArrayResultScalar = new Double[]{7.3, 25.55, 25.0, 2.65};
            Double[] actualArrayResultScalar = new Double[testArrayExpressionScalar.length];
            for (int i = 0; i < testArrayExpressionScalar.length; i++) {
                try{
                Var scalarI = testParser.calculate(testArrayExpressionScalar[i]);
                double actualResultScalarI = Double.parseDouble(scalarI.toString());
                actualArrayResultScalar[i] = actualResultScalarI;
            }catch (CalcException e){
                    System.out.println("Тест не пройден. Сообщение об ошибке:");
                    e.printStackTrace();
                    System.out.println();
                }
            }
            for (int i = 0; i < testArrayExpressionScalar.length; i++) {
                assertEquals("Неправильный результат вычисления: " +
                        testArrayExpressionScalar[i], testArrayResultScalar[i], actualArrayResultScalar[i]);
                System.out.println("Выражение: " + testArrayExpressionScalar[i] + " выполнено успешно." +
                        "\nРезультат: " + actualArrayResultScalar[i] + '\n');
            }
    }

    @Test
    public void testVectorOperation() {
            String[] testArrayExpressionVector = new String[]{"Q={1,2,3}+{4,-5,-6}", "W=Q-{2,-2,20}", "W1=W+{3,11,4}*Q", "W2=Q*W"};
            String[] testArrayResultVector = new String[]{"{5.0, -3.0, -3.0}", "{3.0, -1.0, -23.0}", "{-27.0, -31.0, -53.0}", "87.0"};
            String[] actualArrayResultVector = new String[testArrayExpressionVector.length];
        for (int i = 0; i < testArrayExpressionVector.length; i++) {
            try{
            Var vectorI = testParser.calculate(testArrayExpressionVector[i]);
            String actualResultVectorI = vectorI.toString();
            actualArrayResultVector[i] = actualResultVectorI;
            }catch (CalcException e){
                System.out.println("Тест не пройден. Сообщение об ошибке:");
                e.printStackTrace();
                System.out.println();
            }
        }
        for (int i = 0; i < testArrayExpressionVector.length; i++) {
            assertEquals("Неправильный результат вычисления: " +
                    testArrayExpressionVector[i], testArrayResultVector[i], actualArrayResultVector[i]);
            System.out.println("Выражение: " + testArrayExpressionVector[i] + " выполнено успешно." +
                    "\nРезультат: " + actualArrayResultVector[i] + '\n');
        }
    }

    @Test
    public void testMatrixOperation() {
        String[] testArrayExpressionMatrix = new String[]{"Z={{1,2,3},{4,-5,-6}}+{{1,2,3},{4,-5,-6}}",
                "X=Z-{{7,-8,9},{-10,11,12}}"};
        String[] testArrayResultMatrix = new String[]{"{{2.0, 4.0, 6.0}, {8.0, -10.0, -12.0}}",
                "{{-5.0, 12.0, 6.0}, {18.0, -21.0, -12.0}}"};
        String[] actualArrayResultMatrix = new String[testArrayExpressionMatrix.length];
        for (int i = 0; i < testArrayExpressionMatrix.length; i++) {
            try{
                Var matrixI = testParser.calculate(testArrayExpressionMatrix[i]);
                String actualResultVectorI = matrixI.toString();
                actualArrayResultMatrix[i] = actualResultVectorI;
            }catch (CalcException e){
                System.out.println("Тест не пройден. Сообщение об ошибке:");
                e.printStackTrace();
                System.out.println();
            }
        }
        for (int i = 0; i < testArrayExpressionMatrix.length; i++) {
            assertEquals("Неправильный результат вычисления: " +
                    testArrayExpressionMatrix[i], testArrayResultMatrix[i], actualArrayResultMatrix[i]);
            System.out.println("Выражение: " + testArrayExpressionMatrix[i] + " выполнено успешно." +
                    "\nРезультат: " + actualArrayResultMatrix[i] + '\n');
        }
    }


}