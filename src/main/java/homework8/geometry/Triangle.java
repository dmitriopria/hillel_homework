package homework8.geometry;

public class Triangle implements GeometricFigure {

    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        return 0.5 * height * base;
    }
}
