package cars;

// Implementação de um caminhão
public class TruckCar extends Car {

    public TruckCar() {
        super("Truck Car");
    }

    @Override
    public void drive() {
        System.out.println("Driving a truck...");
    }
}