package hw27.builder;

import hw27.builder.car_details.*;

import java.util.Objects;

public class CarFactory {
    public void constructSportsCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(TripComputer.MULTITRONIX);
    }

    public void constructCityCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(4);
        builder.setEngine(new Engine(1.2));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(TripComputer.KONNWEI);
        builder.setGPSNavigator(GPSNavigator.GARMIN);
    }

    public void constructSUV(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(GPSNavigator.TOMTOM);
    }
}
