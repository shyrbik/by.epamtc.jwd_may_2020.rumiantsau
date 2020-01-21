package by.it.popkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    static void getContract(Class<?> aClass){
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) System.out.println(method.getName());
        }
    }

    public static void main(String[] args) {
        getContract(String.class);
    }
}
