package abstractFactory;

import cars.*;
// Implementação da fábrica para criar carros para empresas
public class CompanyCarFactory implements IAbstractCarFactory{

    @Override
    public Car createCar(String type) {
        switch (type.toLowerCase()) {
            case "sedan":
                return new SedanCar();
            case "sports":
                return new SportsCar();
            case "suv":
                return new SUVCar();
            case "truck":
                return new TruckCar();
            default:
                throw new IllegalArgumentException("Tipo de carro não suportado.");
        }    }
}
