package by.it.popkov.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                sb.append("public ");
                if (Modifier.isStatic(method.getModifiers())) {
                    sb.append("static ");
                }
                sb.append(method.getReturnType().getName()).append(" ").append(method.getName()).append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    sb.append(parameterTypes[i].getName());
                    if (i != parameterTypes.length - 1) sb.append(",");
                }
                sb.append(")").append("\n");
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            sb.append(field.getType().getName()).append(" ").append(field.getName()).append("\n");
        }
        System.out.println(sb);
    }
}
