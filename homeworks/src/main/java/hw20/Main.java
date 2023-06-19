package hw20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(1000);
        List<FuelDispenser> dispensers = new ArrayList<>();
        dispensers.add(new FuelDispenser(station, 30));
        dispensers.add(new FuelDispenser(station, 10));
        dispensers.add(new FuelDispenser(station, 20));
        dispensers.add(new FuelDispenser(station, 60));
        dispensers.add(new FuelDispenser(station, 70));
        dispensers.add(new FuelDispenser(station, 20));
        dispensers.add(new FuelDispenser(station, 10));
        dispensers.add(new FuelDispenser(station, 15));
        dispensers.add(new FuelDispenser(station, 25));
        dispensers.add(new FuelDispenser(station, 20));
        try (ExecutorService executor = Executors.newFixedThreadPool(dispensers.size())) {
            executor.invokeAll(dispensers);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
