package hw20;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(100);
        FuelDispenser dispenser1 = new FuelDispenser(station, 30);
        FuelDispenser dispenser2 = new FuelDispenser(station, 10);
        FuelDispenser dispenser3 = new FuelDispenser(station, 20);
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            executor.invokeAll(List.of(dispenser1, dispenser2, dispenser3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
