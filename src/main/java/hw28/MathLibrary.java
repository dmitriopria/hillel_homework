package hw28;

public class MathLibrary {
    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor mustn't be 0!");
        }
        return a / b;
    }

    public static double power(double base, double exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number!");
        } else if (a == 0) {
            return 0;
        }
        double temp;
        double squareRoot = a / 2;
        do {
            temp = squareRoot;
            squareRoot = (temp + (a / temp)) / 2;
        } while ((temp - squareRoot) != 0);
        return squareRoot;
    }
}
