package by.it.popkov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Bean bean = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                StringBuilder sb = new StringBuilder();
                Param annotation = method.getAnnotation(Param.class);
                sb.append(method.getName()).append(" ").append(method.invoke(bean, annotation.a(), annotation.b()));
                System.out.println(sb);
            }
        }


    }
}
