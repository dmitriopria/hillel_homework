package hw27.builder;

import hw27.builder.car_details.*;

import java.util.Objects;

public class CarFactory {
    public void constructSportsCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.carType(CarType.SPORTS_CAR);
        builder.seats(2);
        builder.engine(new Engine(3.0));
        builder.transmission(Transmission.SEMI_AUTOMATIC);
        builder.tripComputer(TripComputer.MULTITRONIX);
    }

    public void constructCityCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.carType(CarType.CITY_CAR);
        builder.seats(4);
        builder.engine(new Engine(1.2));
        builder.transmission(Transmission.AUTOMATIC);
        builder.tripComputer(TripComputer.KONNWEI);
        builder.gpsNavigator(GPSNavigator.GARMIN);
    }

    public void constructSUV(Builder builder) {
        Objects.requireNonNull(builder);
        builder.carType(CarType.SUV);
        builder.seats(4);
        builder.engine(new Engine(2.5));
        builder.transmission(Transmission.MANUAL);
        builder.gpsNavigator(GPSNavigator.TOMTOM);
    }
}
