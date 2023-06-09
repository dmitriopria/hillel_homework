package hw27;

import hw27.builder.Car;
import hw27.builder.CarBuilder;
import hw27.builder.CarFactory;
import hw27.factory.FurnitureFactory;
import hw27.strategy.SquareCalculator;
import hw27.strategy.figure.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 8);
        SquareCalculator squareCalculator = new SquareCalculator();
        squareCalculator.setGeometricFigure(triangle);
        System.out.println(squareCalculator.calculateSquare());

        CarFactory carFactory = new CarFactory();
        CarBuilder builder = new CarBuilder();
        carFactory.constructCityCar(builder);
        Car car = builder.build();
        System.out.println(car);

        FurnitureFactory furnitureFactory = new FurnitureFactory();
        System.out.println(furnitureFactory.createFurniture("chair"));
    }
}
