package hw13;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] array = fillArray(1000);
        System.out.println(Arrays.toString(array));
        // Bubble sort
        var startBubbleSort = System.currentTimeMillis();
        int[] sortedArray1 = bubbleSort(array);
        var endBubbleSort = System.currentTimeMillis();
        System.out.println("Bubble sort: " + (endBubbleSort - startBubbleSort));
        System.out.println(Arrays.toString(sortedArray1));
        // Insertion sort
        var startInsertionSort = System.currentTimeMillis();
        int[] sortedArray2 = insertionSort(array);
        var endInsertionSort = System.currentTimeMillis();
        System.out.println("Insertion sort: " + (endInsertionSort - startInsertionSort));
        System.out.println(Arrays.toString(sortedArray2));
    }

    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    private static int[] fillArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(arraySize);
        }
        return array;
    }
}
