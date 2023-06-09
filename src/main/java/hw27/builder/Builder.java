package hw27.builder;

import hw27.builder.car_details.*;

public interface Builder {
    void carType(CarType type);

    void seats(int seats);

    void engine(Engine engine);

    void transmission(Transmission transmission);

    void tripComputer(TripComputer tripComputer);

    void gpsNavigator(GPSNavigator gpsNavigator);
}
