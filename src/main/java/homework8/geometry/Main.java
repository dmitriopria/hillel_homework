package homework8.geometry;

public class Main {
    public static void main(String[] args) {
        GeometricFigure[] figures =
                {new Circle(2), new Triangle(5, 8), new Square(4)};
        double totalArea = 0;
        for (GeometricFigure figure : figures) {
            totalArea += figure.getArea();
        }
        System.out.printf("Total area: %.3f", totalArea);
    }

}
