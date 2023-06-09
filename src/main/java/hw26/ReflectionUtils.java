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

public class ReflectionUtils {
    static AnnotatedMethodContainer createMethodContainer(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeSuiteMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .toList();
        List<Method> afterSuiteMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                .toList();
        List<Method> testMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(ReflectionUtils::sortedByPriority))
                .toList();
        return new AnnotatedMethodContainer(beforeSuiteMethods, afterSuiteMethods, testMethods);
    }

    private static int sortedByPriority(Method m) {
        Objects.requireNonNull(m);
        Priority testAnnotation = Test.class.getAnnotation(Priority.class);
        Priority priorityAnnotation = m.getAnnotation(Priority.class);
        return priorityAnnotation == null ? testAnnotation.priority() : priorityAnnotation.priority();
    }

    static void checkSuiteAnnotationDuplicates(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        boolean hasDuplicateBeforeSuite = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .count() > 1;
        boolean hasDuplicateAfterSuite = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                .count() > 1;
        if (hasDuplicateBeforeSuite || hasDuplicateAfterSuite) {
            throw new RuntimeException("There should be only one @BeforeSuite and one @AfterSuite method");
        }
    }

    static void invokeMethod(Method method, Object instance) {
        try {
            method.invoke(instance);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke method %s!".formatted(method), e);
        }
    }
}
