package carlistprojetc;

public class MainCar {
    public static void main(String[] args) {
        CarList<Car> carList = new CarList<>(); //CarList = new CarList<>();

        carList.addCar(new Sedan("Toyota", "Corolla"));
        carList.addCar(new Suv("Honda", "Civic"));
        System.out.println("carList.getCar(0) = " + carList.getCar(0) + "\n");

        System.out.println("Cars : " + carList);

    }
}
