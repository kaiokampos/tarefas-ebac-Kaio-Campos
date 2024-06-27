package cars;

// Implementação de um carro esportivo
public class SportsCar extends Car {

    public SportsCar() {
        super("Sports Car");
    }

    @Override
    public void drive() {
        System.out.println("Driving a sports car...");
    }
}
