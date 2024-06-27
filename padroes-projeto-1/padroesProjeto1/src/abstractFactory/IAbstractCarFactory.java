package abstractFactory;

import cars.Car;

// Interface da fábrica abstrata
public interface IAbstractCarFactory {
    Car createCar(String type);
}
