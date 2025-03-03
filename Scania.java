package lab2_old;
import java.awt.*;

public class Scania extends Truck{

    private TruckBed bed;
    boolean running;

    public Scania(int i, int i1){
        super(new TruckBed());

        nrDoors = 2;
        color = Color.orange;
        enginePower = 200;
        modelName = "Scania";
        bed = new TruckBed();
        bed.setAngle(0, getCurrentSpeed());
        size = 10;
        stopEngine();
        this.x = i;
        this.y = i1;
        this.running = false;
        }

    public boolean isRunning(){return this.running;}

    public void flipIsRunning(){this.running = !this.running;}

    @Override
    public void gas(double amount){
        if(getAngle() == 0){
            super.gas(amount);
        }
    }
}





