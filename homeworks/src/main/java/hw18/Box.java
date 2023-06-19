package hw18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        Objects.requireNonNull(fruit);
        if (fruits.isEmpty() || fruits.get(0).getClass() == fruit.getClass()) {
            fruits.add(fruit);
        } else {
            throw new RuntimeException("Can't add different fruit type to the box!");
        }
    }

    public void add(int fruitsQuantity, T fruit) {
        Objects.requireNonNull(fruit);
        validateFruitsQuantity(fruitsQuantity);
        for (int i = 0; i < fruitsQuantity; i++) {
            add(fruit);
        }
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0F;
        } else {
            return fruits.size() * fruits.get(0).getWeight();
        }
    }

    public boolean compare(Box<?> otherBox) {
        Objects.requireNonNull(otherBox);
        return this.getWeight() == otherBox.getWeight();
    }

    public Box<T> merge(Box<T> otherBox) {
        Objects.requireNonNull(otherBox);
        if (fruits.isEmpty() || fruits.get(0).getClass() == otherBox.fruits.get(0).getClass()) {
            fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            throw new RuntimeException("Can't merge different fruit types!");
        }
        return otherBox;
    }

    private int validateFruitsQuantity(int fruitsQuantity) {
        if (fruitsQuantity < 1) {
            throw new IllegalArgumentException("Wrong fruits quantity!");
        }
        return fruitsQuantity;
    }
}
