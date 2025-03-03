package lab2_old;
import java.awt.*;

public class Volvo240 extends Vehicle implements PersonalCar{

    private final static double trimFactor = 1.25;
    boolean running;
    
    public Volvo240(int i, int i1){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        size = 4.87;
        this.x = i;
        this.y = i1;
        this.running = false;
    }
    public boolean isRunning(){return this.running;}

    public void flipIsRunning(){this.running = !this.running;}

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void setX(double xCoord) {
        super.setX(xCoord);
    }

    @Override
    public void setY(double yCoord) {
        super.setY(yCoord);
    }

    @Override
    public double getX() {
        return super.x;
    }

    @Override
    public double getY() {
        return super.y;
    }

}
