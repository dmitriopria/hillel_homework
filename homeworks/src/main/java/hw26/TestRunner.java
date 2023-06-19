package hw26;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import static hw26.ReflectionUtils.*;

public class TestRunner {
    public static void start(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        try {
            ReflectionUtils.checkSuiteAnnotationDuplicates(clazz);
            AnnotatedMethodContainer annotatedMethod = ReflectionUtils.createMethodContainer(clazz);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            if (!annotatedMethod.beforeSuiteMethods().isEmpty()) {
                annotatedMethod.beforeSuiteMethods().forEach(method -> ReflectionUtils.invokeMethod(method, instance));
            }
            if (!annotatedMethod.testMethods().isEmpty()) {
                annotatedMethod.testMethods().forEach(method -> ReflectionUtils.invokeMethod(method, instance));
            }
            if (!annotatedMethod.afterSuiteMethods().isEmpty()) {
                annotatedMethod.afterSuiteMethods().forEach(method -> ReflectionUtils.invokeMethod(method, instance));
            }
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Unable to get an instance of class %s!".formatted(clazz), e);
        }
    }
}