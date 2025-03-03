package lab2_old;
import java.awt.*;

public abstract class Vehicle extends Position implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x;
    protected double y; // Ändra sen om det ska från pub
    protected double currDirection = 0;
    protected double size;
    private boolean isLoaded = false;
    private boolean running = false;
    public void setCurrentspeed(double speed){currentSpeed = speed;
    }
    public double getSize(){return size;}
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public boolean getIsLoaded(){return isLoaded;}
    public void setIsLoaded(boolean idk){isLoaded = idk;}

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public boolean isRunning(){return this.running;}

    public void setIsRunning(boolean falseOrTrue){this.running = falseOrTrue;}

    public void move(){
        if (currDirection == 0) y += currentSpeed;
        else if (currDirection == 180) y += (-currentSpeed);
        else if (currDirection == 90) x += currentSpeed;
        else if (currDirection == 270) x += (-currentSpeed);
    }

    public void turnLeft(){
        currDirection = (currDirection+90)%360;
    }


    public void turnRight(){
        currDirection = (currDirection+270)%360;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("0 <= amount <= 1");
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("0 <= amount <= 1");
        decrementSpeed(amount);
    }

}
