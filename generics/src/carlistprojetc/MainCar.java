package carlistprojetc;

public class MainCar {
    public static void main(String[] args) {
        CarList<Sedan> sedanList = new CarList<>();
        //Sedan toyotaCorola = new Sedan("Toyota", "Corolla");
        //sedanList.addCar(toyotaCorola);
        sedanList.addCar(new Sedan("Toyota", "Corolla"));
        sedanList.addCar(new Sedan("Honda", "Accord"));
        System.out.println("sedanList.getCar(0) = " + sedanList.getCar(0) + "\n");

        CarList<Suv> suvList = new CarList<>();
        suvList.addCar(new Suv("Nissan", "Altima"));
        suvList.addCar(new Suv("Volkswagen", "Golf"));
        System.out.println("suvList.getCar(0) = " + suvList.getCar(0) + "\n");

        System.out.println("Sedan List: " + sedanList);
        System.out.println("SUV List: " + suvList);
    }
}
