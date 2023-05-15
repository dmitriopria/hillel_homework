package hw26;

import hw26.annotations.AfterSuite;
import hw26.annotations.BeforeSuite;
import hw26.annotations.Priority;
import hw26.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TestRunner {
    public static void start(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        try {
            checkSuiteAnnotationDuplicates(clazz);
            AnnotatedMethodContainer annotatedMethod = getMethod(clazz);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            annotatedMethod.beforeSuiteMethods().forEach(method -> invokeMethod(method, instance));
            annotatedMethod.testMethods().forEach(method -> invokeMethod(method, instance));
            annotatedMethod.afterSuiteMethods().forEach(method -> invokeMethod(method, instance));
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Unable to get instance of class %s!".formatted(clazz), e);
        }
    }

    private static AnnotatedMethodContainer getMethod(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeSuiteMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .toList();
        List<Method> afterSuiteMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                .toList();
        List<Method> testMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(TestRunner::sortedByPriority))
                .toList();
        return new AnnotatedMethodContainer(beforeSuiteMethods, afterSuiteMethods, testMethods);
    }

    private static int sortedByPriority(Method m) {
        Priority testAnnotation = Test.class.getAnnotation(Priority.class);
        Priority priorityAnnotation = m.getAnnotation(Priority.class);
        return priorityAnnotation == null ? testAnnotation.priority() : priorityAnnotation.priority();
    }

    private static void checkSuiteAnnotationDuplicates(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        long beforeSuiteCount = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .count();
        long afterSuiteCount = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                .count();
        if (beforeSuiteCount > 1 || afterSuiteCount > 1) {
            throw new RuntimeException("There should be only one @BeforeSuite and one @AfterSuite method");
        }
    }

    private static void invokeMethod(Method method, Object instance) {
        try {
            method.invoke(instance);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke method %s!".formatted(method), e);
        }
    }
}