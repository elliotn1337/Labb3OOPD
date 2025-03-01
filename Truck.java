package labb1_objekt;
public abstract class Truck extends Vehicle {

    private TruckBed bed;

    Truck(TruckBed bed) {
        this.bed = bed;
    }

    public double getAngle() {
        return bed.getAngle();
    }

    public void raise(int degrees){
        bed.Raise(degrees, getCurrentSpeed());
    }

    public void lower(int degrees){
        bed.Lower(degrees, getCurrentSpeed());
    }

    @Override
    public void startEngine(){
        int truckBedAngle = bed.getAngle();

        if (truckBedAngle == 0) {setCurrentspeed(0.1);}

        else{throw new IllegalArgumentException("Angle must be 0 to start the engine");}



    }

}


