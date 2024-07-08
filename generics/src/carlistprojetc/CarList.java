package carlistprojetc;

import java.util.ArrayList;
import java.util.List;

public class CarList <T extends Car >{
    private List<T> carsList;

    public CarList(){
        carsList = new ArrayList<>();
    }

    public void addCar(T car){
        carsList.add(car);
    }

    public T getCar(int index){
        return carsList.get(index);
    }

    public int size(){
        return carsList.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarList{");
        sb.append("carsList=").append(carsList);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
}
