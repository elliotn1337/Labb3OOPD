package lab2_old;
import java.awt.*;

public class Scania extends Truck{

    private TruckBed bed;
    boolean running;

    public Scania(int x, int y){
        super(new TruckBed());

        nrDoors = 2;
        color = Color.orange;
        enginePower = 200;
        modelName = "Scania";
        bed = new TruckBed();
        bed.setAngle(0, getCurrentSpeed());
        size = 10;
        stopEngine();
        this.y = y;
        this.x = x;
        }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public void gas(double amount){
        if(getAngle() == 0){
            super.gas(amount);
        }
    }
}





