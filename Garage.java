package lab2_old;
import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Vehicle> {
    private int maxNmr = 10;
    private List<T> loadedVehicles = new ArrayList<T>();      //bilar i garaget
    public void setMaxNmr(int max) {
        maxNmr = max;
    }

    public int getMaxNmr() {
        return maxNmr;
    }

    public void loadVehicle(T car) {
        if (loadedVehicles.size() == maxNmr) {
            throw new ArrayStoreException("Already full garage");

        } else {
            loadedVehicles.add(car);
            car.setIsLoaded(true);

        }
    }
    public int getGarageLoaded(){return loadedVehicles.size();}

    public T deloadVehicle (int index) {
        T delodedVechical = null;
        if(index != 0 && index < loadedVehicles.size()){
            delodedVechical = loadedVehicles.get(index);
            loadedVehicles.remove(index);
           // delodedVechical.setLoaded(false);
            return delodedVechical;
        }

        else{ throw new IllegalArgumentException("Wrong Index");}
    }
}

