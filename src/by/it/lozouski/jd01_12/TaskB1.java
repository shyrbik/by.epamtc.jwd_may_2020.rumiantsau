package by.it.lozouski.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {
        Pattern myRegexPattern = Pattern.compile("['a-zA-Z]+"); //паттерн регулярки для матчера
        Scanner sc1 = new Scanner(System.in); //сканер
        Map<String, Integer> myMap = new HashMap<>();//создадим мапу
        boolean flag = false; // флаг для цикла

        while (!flag) { //...пока флаг не false, т.е. true
            String text = sc1.next(); //присвоим введенный текст в переменную
            Matcher matcher = myRegexPattern.matcher(text); // создадим матчер для текста
            while (matcher.find()) { //...пока матчер что-то нашел
                String word = matcher.group();// присвоим найденное переменной
                if (word.equals("end")) {//если word совпадает с end
                    flag = true; //...флаг на true,чтобы свернуть внешний цикл while
                    break; //.. и сворачиваем текуший while
                }
                Integer value = myMap.get(word); // получим value по ключу word(найденое матчером по regex слово)
                if (value == null) myMap.put(word, 1); //если еще не встречалось, запишем в value = 1 (кол-во раз)
                else myMap.put(word, value + 1); // если встречалось...добавим в value +1
            }
        }
        //распечатка мапы : myMap.entrySet().for
        for (Map.Entry<String, Integer> values : myMap.entrySet()) {
            System.out.println(values.getKey()+"="+values.getValue());
        }
    }
}

