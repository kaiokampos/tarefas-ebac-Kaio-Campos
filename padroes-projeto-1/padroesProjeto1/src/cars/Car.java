package cars;

// Classe abstrata que representa um carro
public abstract class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void drive();
}