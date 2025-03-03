package lab2_old;
import java.awt.*;
import java.util.ArrayList;

public class transportCar<T extends PersonalCar> extends Truck {
    protected int carDistance;
    private final ArrayList <T> loadedCars = new ArrayList<T>(9);
    boolean running;

    public transportCar() {
        super(new TruckBed());
        nrDoors = 2;
        color = Color.pink;
        enginePower = 1500;
        modelName = "Car transporter";
        double angle = 70;
        size = 20;
        running = false;
    }

    public ArrayList<T> getLoadedCars(){return loadedCars;}

    public int getLoaded(){return loadedCars.size();}

    public void open() {
        this.raise(70);

    }
    //Om du vill sänka den så blir den automatiskt 0
    public void close() {
        this.lower(0);
    }


    public void loadCar(T car){
        int maxCapacity = 9;
        if (this.getAngle() == 0 && getCurrentSpeed() == 0 && carDistance <= 1 && car.getSize() < 6 && loadedCars.size() < maxCapacity) {

                loadedCars.add(car);
                carDistance = 0;

            }
            else {
                throw new IllegalArgumentException("Something is wrong!");
            }
        }

    public void deloadCar(){
        if (this.getAngle() == 0 && carDistance <= 1 && getCurrentSpeed() == 0) {
            loadedCars.removeLast();
            carDistance = 1;

        } else {
            throw new IllegalArgumentException("Something is wrong!");
        }
    }

    @Override
    public void move(){
        super.move();
        for (T car : loadedCars ){
            double y =  getY();
            double x = getX();
            car.setY(y);
            car.setX(x);
        }
    }
    }
