package by.it.filipovich.jd01_12;

import java.util.*;

public class TaskB1 {
    private Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TaskB1 taskB1 = new TaskB1();
        String[] words = new String[]{};
        Scanner scanner = new Scanner(System.in);
        String text;
        while (!(text = scanner.nextLine()).equals("end")){
            words = text.replaceAll("[^а-яА-ЯёЁ]+", " ")
                    .replaceAll(" {2,}", " ")
                    .split(" ");
        }
        System.out.println(taskB1.toString(words));
        taskB1.map.put(words[1],1);
        System.out.println(taskB1.map);
        for (String word : words) {
            for (Map.Entry<String, Integer> entry : taskB1.map.entrySet()) {
                Iterator<Map.Entry<String, Integer>> iter = taskB1.map.entrySet().iterator();
                if(!(word.equals(entry.getKey()))) {
                    iter.next().setValue(1);
                } else
                    taskB1.map.put(word, taskB1.map.get(word)+1);
            }
        }
        System.out.println(taskB1.map);
    }

    @Override
    public String toString() {
        return "TaskB1{" +
                "map=" + map +
                '}';
    }

    public String toString(String[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.append(arr[arr.length-1]).append("}");
        return sb.toString();
    }
}
