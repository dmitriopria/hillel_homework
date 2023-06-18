package hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathLibraryTest {
    @Test
    void whenPerformSumOperationThenReturnCorrectResult() {
        double result = MathLibrary.sum(2.5, 3.5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void whenPerformSubtractOperationThenReturnCorrectResult() {
        double result = MathLibrary.subtract(5.0, 2.5);
        Assertions.assertEquals(2.5, result);
    }

    @Test
    void whenPerformMultiplyOperationThenReturnCorrectResult() {
        double result = MathLibrary.multiply(2.0, 3.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void whenPerformDivideOperationThenReturnCorrectResult() {
        double result = MathLibrary.divide(10.0, 2.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    void whenDivideByZeroThenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathLibrary.divide(10.0, 0.0);
        });
    }

    @Test
    void whenPerformPowerOperationThenReturnCorrectResult() {
        double result = MathLibrary.power(2.0, 3.0);
        Assertions.assertEquals(8.0, result);
    }

    @Test
    void whenExponentIsZeroThenPowerResultIsOne() {
        double result = MathLibrary.power(33.3, 0);
        Assertions.assertEquals(1.0, result);
    }

    @Test
    void whenPerformSquareRootOperationThenReturnCorrectResult() {
        double result = MathLibrary.squareRoot(9.0);
        Assertions.assertEquals(3.0, result);
    }

    @Test
    void whenPerformSquareRootOfNegativeNumberThenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathLibrary.squareRoot(-9.0);
        });
    }

    @Test
    void whenSquareRootOfZeroThenResultIsZero() {
        double result = MathLibrary.squareRoot(0);
        Assertions.assertEquals(0, result);
    }
}