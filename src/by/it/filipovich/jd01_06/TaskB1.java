package by.it.filipovich.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String str = Poem.text;

        String[] words = str.split(" ");
        // Разбиение строки на слова с помощью разграничителя (пробел)
        // Вывод на экран
        for(String subStr:words) {
            System.out.println(subStr);
        }
    }
}
