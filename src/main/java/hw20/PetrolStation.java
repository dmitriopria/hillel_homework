package hw20;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation {
    private int amount;
    private final Lock lock = new ReentrantLock();

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public int doRefuel(int requestedAmount) {
        long randomTime = (long) (Math.random() * 7000 + 3000);
        lock.lock();
        try {
            if (amount >= requestedAmount) {
                Thread.sleep(randomTime);
                amount -= requestedAmount;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return amount;
    }

    public int getAmount() {
        return amount;
    }
}
