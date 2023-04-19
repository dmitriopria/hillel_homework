package hw19;

import java.util.Arrays;

public class ValueCalculator {
    private final float[] array;
    private static final int SIZE = 1_000_000;
    private static final int HALF_SIZE = SIZE / 2;

    public ValueCalculator() {
        this.array = new float[SIZE];
    }

    public long calculateFillingTime(int value) {
        long startTime = System.currentTimeMillis();
        fillArray(value);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void fillArray(int value) {
        Arrays.fill(array, value);
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
    }

    private Thread createThread(float[] inputArray) {
        return new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                inputArray[i] = (float) (inputArray[i] * Math.sin(0.2f + (float) i / 5)
                        * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });
    }
}
