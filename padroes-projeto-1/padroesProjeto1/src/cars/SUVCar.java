package cars;
// Implementação de um carro SUV
public class SUVCar extends Car {

    public SUVCar() {
        super("SUV Car");
    }

    @Override
    public void drive() {
        System.out.println("Driving an SUV car...");
    }
}