package labb1_objekt;
import java.awt.*;

public class Scania extends Truck{

    private TruckBed bed;

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
        }

    @Override
    public void gas(double amount){
        if(getAngle() == 0){
            super.gas(amount);
        }
    }
}





