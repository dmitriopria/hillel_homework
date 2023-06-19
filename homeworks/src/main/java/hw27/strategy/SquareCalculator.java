package hw27.strategy;

import hw27.strategy.figure.GeometricFigure;

import java.util.Objects;

public class SquareCalculator {
    private GeometricFigure geometricFigure;

    public double calculateSquare() {
        return geometricFigure.calculateSquare();
    }

    public GeometricFigure getGeometricFigure() {
        return geometricFigure;
    }

    public void setGeometricFigure(GeometricFigure geometricFigure) {
        this.geometricFigure = geometricFigure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareCalculator that = (SquareCalculator) o;
        return Objects.equals(geometricFigure, that.geometricFigure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geometricFigure);
    }
}
