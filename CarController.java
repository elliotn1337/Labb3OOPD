package lab2_old;


import java.awt.image.BufferedImage;


public class CarController {

    private int i = 0;
    protected VehicleManager vehicleManager;
    BufferedImage volvoImage;

    public CarController() {
        this.vehicleManager = new VehicleManager();
    }


    void gas(int amount) {
        vehicleManager.gas(amount);
    }

    void brake(int amount) {
        vehicleManager.brake(amount);
    }

    void turnLeft() {
        vehicleManager.turnLeft();
    }

    void turnRight() {
        vehicleManager.turnRight();
    }

    void turboOn() {
        vehicleManager.turboOn();
    }

    void turboOff() {
        vehicleManager.turboOff();
    }

    void startEngine() {
        vehicleManager.startEngine();
    }

    void stopEngine() {
        vehicleManager.stopEngine();
    }

    void raise(int amount) {
        vehicleManager.raise(amount);
    }

    void lower(int amount) {
        vehicleManager.lower(amount);
    }

    void addCar() {
        vehicleManager.addCar();
    }
    void removeCar(){
        vehicleManager.removeCar();
    }

    void deloadCar() {
        vehicleManager.deloadCar();
    }

}