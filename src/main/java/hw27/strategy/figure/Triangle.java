package hw27.strategy.figure;

import java.util.Objects;

public class Triangle implements GeometricFigure {
    private double bottom;
    private double height;

    public Triangle(double bottom, double height) {
        if (bottom > 0 && height > 0) {
            this.bottom = bottom;
            this.height = height;
        } else throw new IllegalArgumentException("Value must be > 0");
    }

    @Override
    public double calculateSquare() {
        return 0.5 * bottom * height;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.bottom, bottom) == 0 && Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottom, height);
    }
}
