package hw19;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValueCalculator {
    private final float[] array;
    private static final int SIZE = 1_000_000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final Logger LOGGER = Logger.getLogger(ValueCalculator.class.getName());

    public ValueCalculator() {
        this.array = new float[SIZE];
    }

    public long calculateFillingTime() {
        long startTime = System.currentTimeMillis();
        fillArray();
        long endTime = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Filling array time is %d milliseconds".formatted(endTime - startTime));
        return endTime - startTime;
    }

    private synchronized float[] fillArray() {
        float[] firstHalf = new float[HALF_SIZE];
        float[] secondHalf = new float[HALF_SIZE];
        System.arraycopy(array, 0, firstHalf, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, secondHalf, 0, HALF_SIZE);
        Thread tread1 = createThread(firstHalf);
        Thread tread2 = createThread(secondHalf);
        tread1.start();
        tread2.start();
        try {
            tread1.join();
            tread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(firstHalf, 0, array, 0, HALF_SIZE);
        System.arraycopy(secondHalf, 0, array, HALF_SIZE, HALF_SIZE);
        return array;
    }

    private Thread createThread(float[] inputArray) {
        return new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                inputArray[i] = ThreadLocalRandom.current().nextFloat(inputArray.length);
            }
        });
    }

    @Override
    public String toString() {
        return "ValueCalculator{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
