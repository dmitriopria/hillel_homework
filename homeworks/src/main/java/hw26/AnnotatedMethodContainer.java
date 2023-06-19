package hw26;

import java.lang.reflect.Method;
import java.util.List;

public record AnnotatedMethodContainer(List<Method> beforeSuiteMethods,
                                       List<Method> afterSuiteMethods,
                                       List<Method> testMethods) {
}