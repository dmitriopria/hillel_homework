package homework8.geometry;

import java.util.Objects;

public interface GeometricFigure {
    double getArea();

    static double calculateTotalArea(GeometricFigure[] figures) {
        Objects.requireNonNull(figures);
        double totalArea = 0;
        for (GeometricFigure figure : figures) {
            totalArea += figure.getArea();
        }
        return totalArea;
    }
}
