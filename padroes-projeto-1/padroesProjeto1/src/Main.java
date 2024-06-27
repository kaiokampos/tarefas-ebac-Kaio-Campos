import abstractFactory.CarFactory;
import abstractFactory.CompanyCarFactory;
import abstractFactory.IAbstractCarFactory;
import cars.Car;

public class Main {

    public static void main(String[] args) {
        IAbstractCarFactory carFactory = new CarFactory();
        IAbstractCarFactory companyCarFactory = new CompanyCarFactory();

        Car sedan = carFactory.createCar("sedan");
        sedan.drive();

        Car sports = companyCarFactory.createCar("sports");
        sports.drive();

        Car suv = carFactory.createCar("suv");
        suv.drive();

        Car truck = companyCarFactory.createCar("truck");
        truck.drive();
    }
}