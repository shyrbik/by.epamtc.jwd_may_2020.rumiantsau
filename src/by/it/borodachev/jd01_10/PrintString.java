package by.it.borodachev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {

        Class<String> mathClass = String.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder str = new StringBuilder("");

 //         if (Modifier.isPublic(modifiers) && !(Modifier.isStatic(modifiers))) {
            if (!(Modifier.isStatic(modifiers))) {
                str.append(" ").append(method.getName());
                System.out.println(str);
            }
        }
/*        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            StringBuilder str = new StringBuilder("");
            str.append(field.getType());
            str.append(" ").append(field.getName());
            System.out.println(str);
        }
        */

    }
}
