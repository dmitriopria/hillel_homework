package hw20;

import java.util.concurrent.Callable;

public class FuelDispenser implements Callable<Integer> {
    private final PetrolStation petrolStation;
    private final int requestedAmount;

    public FuelDispenser(PetrolStation petrolStation, int requestedAmount) {
        this.petrolStation = petrolStation;
        this.requestedAmount = requestedAmount;
    }

    @Override
    public Integer call() {
        return petrolStation.doRefuel(requestedAmount);
    }
}
