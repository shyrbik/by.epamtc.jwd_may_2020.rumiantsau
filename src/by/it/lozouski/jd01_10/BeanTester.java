package by.it.lozouski.jd01_10;

import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> testingBean = Bean.class; //Get structure of the class Bean
        Object objBean = testingBean.newInstance(); //This operation return object Bean
        Method[] declaredMethodsBean = testingBean.getDeclaredMethods(); //Get structure of the methods(Class Bean)
        for (Method elem : declaredMethodsBean) {
            if (elem.getAnnotation(Param.class) != null) {
                elem.setAccessible(true); // If method is private, then you get access.
                //Call the method, and assign the result to a variable:
                double resultTest = (double) elem.invoke(objBean, elem.getAnnotation(Param.class).a(), elem.getAnnotation(Param.class).b());
                System.out.println(elem.getName() + " " + resultTest);//sout...
                elem.setAccessible(false);//Deny access
            }
        }
    }
}
