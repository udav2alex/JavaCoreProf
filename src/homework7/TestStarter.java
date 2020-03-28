package homework7;

import java.lang.reflect.Method;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestStarter {

    public static void start(String className) throws Exception {
        Class aClass = Class.forName(className);
        start(aClass);
    }

    public static <T> void start(Class<T> aClass) throws Exception {
        Method[] methods = aClass.getDeclaredMethods();

        SortedSet<TestMethod> testMethods = new TreeSet<>();
        Method beforeMethod = null;
        Method afterMethod = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) {
                    throw new RuntimeException("Задан приоритет вне допустимого диапазона (1-10)!");
                } else {
                    testMethods.add(new TestMethod(method, priority));
                }
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = method;
                } else {
                    throw new RuntimeException("В тестовом классе должен быть " +
                            "только один метод с аннотацией @BeforeSuite!");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = method;
                } else {
                    throw new RuntimeException("В тестовом классе должен быть " +
                            "только один метод с аннотацией @AfterSuite!");
                }
            }
        }

        T obj = aClass.newInstance();

        if (beforeMethod != null) {
            beforeMethod.invoke(obj);
        }

        for (TestMethod testMethod : testMethods) {
            testMethod.method.invoke(obj);
        }

        if (afterMethod != null) {
            afterMethod.invoke(obj);
        }
    }

    private static class TestMethod implements Comparable<TestMethod> {
        Method method;
        int priority;

        TestMethod(Method method, int priority) {
            this.method = method;
            this.priority = priority;
        }

        @Override
        public int compareTo(TestMethod o) {
            if (this.priority == o.priority) {
                return method.getName().compareTo(o.method.getName());
            } else {
                return o.priority - this.priority;
            }
        }
    }
}
