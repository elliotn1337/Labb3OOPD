package lab2_old;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController extends VehicleManager{
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    Application application;
    //methods:
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    // Calls the gas method for each car once
    void gas(int amount) {
        if (car.this.running){
            double gas = ((double) amount) / 100;
            for (Vehicle car : cars) {
                car.gas(gas);
            }}
    }
    void brake(int amount) {
        if (application.running){
            double brake = ((double) amount) / 100;
            for (Vehicle car : cars
            ) {
                car.brake(brake);
            }}
    }
    @Override
    public void turnLeft(){ for (Vehicle car : cars){if (car.running) {car.turnLeft();}}}}

@Override
public void turnRight(){for (Vehicle car : cars){ if(car.running){ {car.turnRight();}}}

    void turboOn() {for (Vehicle car : cars) {
        if (car instanceof Saab95){
            ((Saab95) car).setTurboOn();}}}

    void turboOff() {for (Vehicle car : cars) {
        if (car instanceof Saab95){
            ((Saab95) car).setTurboOff();}}}

    void startEngine(){
        for (Vehicle car : cars) {
            if (!(running)){car.startEngine(); this.running = true;}}}
    void stopEngine(){for (Vehicle car : cars) { car.stopEngine(); running = false;}}
    void raise(int amount) {
        for (Vehicle car : cars) {
            if (car instanceof Scania scania) {
                scania.raise(amount);
            }
        }
    }
    void lower(int amount){
        for (Vehicle car: cars){
            if (car instanceof Scania scania){
                scania.lower(amount);
            }
        }
    }

}