package hw27.strategy.figure;

import java.util.Objects;

public class Square implements GeometricFigure {
    public double width;
    public double height;

    public Square(double width, double height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else throw new IllegalArgumentException("Value must be > 0");
    }

    @Override
    public double calculateSquare() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0 && Double.compare(square.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
