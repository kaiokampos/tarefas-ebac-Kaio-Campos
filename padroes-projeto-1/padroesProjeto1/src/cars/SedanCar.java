package cars;

// Implementação de um carro sedan
public class SedanCar extends Car {

    public SedanCar() {
        super("Sedan Car");
    }

    @Override
    public void drive() {
        System.out.println("Driving a sedan car...");
    }
}
