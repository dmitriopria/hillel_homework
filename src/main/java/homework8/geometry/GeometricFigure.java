package homework8.geometry;

public interface GeometricFigure {
    double getArea();

    static double calculateTotalArea(GeometricFigure[] figures) {
        double totalArea = 0;
        for (GeometricFigure figure : figures) {
            totalArea += figure.getArea();
        }
        return totalArea;
    }
}
