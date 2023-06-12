package hw27.builder;

import hw27.builder.car_details.*;

public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void carType(CarType type) {
        this.type = type;
    }

    @Override
    public void seats(int seats) {
        this.seats = seats;
    }

    @Override
    public void engine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void transmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void tripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void gpsNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car build() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
