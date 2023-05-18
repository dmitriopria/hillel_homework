package hw27.strategy.figure;

import java.util.Objects;

public class Circle implements GeometricFigure {
    public double radius;

    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else throw new IllegalArgumentException("Value must be > 0");
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
