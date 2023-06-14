package hw27.builder;

import hw27.builder.car_details.*;

import java.util.Objects;

public class Car {
    private final CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public void setGpsNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seats == car.seats && carType == car.carType && Objects.equals(engine, car.engine) && transmission == car.transmission && Objects.equals(tripComputer, car.tripComputer) && Objects.equals(gpsNavigator, car.gpsNavigator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                ", seats=" + seats +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", tripComputer=" + tripComputer +
                ", gpsNavigator=" + gpsNavigator +
                '}';
    }
}
