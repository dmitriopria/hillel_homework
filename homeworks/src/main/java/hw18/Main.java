package hw18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"one", "two", "three"};
        List<String> stringList = toList(stringArray);
        System.out.println(stringList);

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
//        appleBox.add(new Orange());
        appleBox.add(5, new Apple());
        System.out.println(appleBox.getWeight());
        Box<Apple> otherAppleBox = new Box<>();
        otherAppleBox.add(new Apple());
        appleBox.merge(otherAppleBox);
        System.out.println(otherAppleBox.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.compare(new Box<>()));
    }


    private static <T> List<T> toList(T[] array) {
        Objects.requireNonNull(array);
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
//        for (T element : array) {
//            list.add(element);
//        }
        return list;
    }
}
