package by.it.filipovich.jd01_04;

public class InOut {
    /**
     * @param line передаваемая в метод строка при его вызове.
     * @return возвращает массив чисел после преобразования строки.
     */
    static double[] getArray(String line) {
        String[] strMas = line.trim().split(" ");
        double[] result = new double[strMas.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(strMas[i]);
        }
        return result;
    }

    public static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param result передаваемый в метод массив вещественных чисел
     * @param name имя массива на экране
     * @param columnCount задаваемое количество столбцов после вывода на печать переданного одномерного массива
     */
    public static void printArray(double[] result, String name, int columnCount) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf(name+"[% -2d]=%-6.2f", i, result[i]);
            if((i+1)%columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }
}
