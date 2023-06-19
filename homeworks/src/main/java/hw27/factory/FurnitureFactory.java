package hw27.factory;

import hw27.factory.furniture.Chair;
import hw27.factory.furniture.Sofa;

import java.util.Objects;

public class FurnitureFactory {
    public String createFurniture(String type) {
        Objects.requireNonNull(type);
        if (type.equalsIgnoreCase("chair")) {
            return new Chair().assemble();
        } else if (type.equalsIgnoreCase("sofa")) {
            return new Sofa().assemble();
        } else {
            throw new IllegalArgumentException("Invalid furniture type: " + type);
        }
    }
}
