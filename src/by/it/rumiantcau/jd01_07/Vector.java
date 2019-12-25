package by.it.rumiantcau.jd01_07;

//    B разработайте для класса Var наследника Vector с тремя конструкторами:
//1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
//2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
//3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
//    Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }



    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter=", ";
        }
        sb.append("}");
       return sb.toString();

  //    return System.out.println(sb);


       // return Arrays.toString(value);


    }



}
