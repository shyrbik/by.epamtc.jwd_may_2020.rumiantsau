package by.it.filipovich.jd01_13;

import java.util.*;

class TaskC {
    private static List<Double> list = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scannerOne = new Scanner(System.in);
        //readData();
        for (int i = 0; i < 3; i++) {
            String next = scannerOne.next();
            double v = Double.parseDouble(next);
            list.add(v);
        }
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list);

    }


//    static void readData() throws InterruptedException {
//
//        try {
//
//            double v = Double.parseDouble(next);
//            list.add(number);
//
//        } catch (IOException e) {
//            Thread.sleep(100);
//            System.out.println(Collections.reverse(list);
//
//        }
//
//    }
//
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        String del = "";
        for (Double aDouble : list) {
            sb.append(del).append(aDouble);
            del = " ";
        }
        return sb.toString();
    }
}
