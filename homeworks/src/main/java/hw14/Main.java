package hw14;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List stringsList = ArrayImplementer.createList();
        System.out.println(stringsList);

        int count = ArrayImplementer.countOccurrence(stringsList, stringsList.get(1).toString());
        System.out.println(stringsList.get(1).toString() + " is repeated " + count + " times.");

        System.out.println(ArrayImplementer.calcOccurrence(stringsList));
        System.out.println(ArrayImplementer.findOccurrence(stringsList));

        Integer[] integersArray = {1, 1, 2, 3, 3, 4, 5, 5};
        System.out.println(ArrayImplementer.toList(integersArray));
        System.out.println(ArrayImplementer.findUnique(Arrays.stream(integersArray).toList()));
    }
}
