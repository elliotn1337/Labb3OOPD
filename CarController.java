package lab2_old;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

import javax.swing.*;

public class CarController extends VehicleManager {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    //methods:
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    public CarView frame;


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            if (v.isRunning()) {
                v.gas(gas);
            }
        }
    }

    void brake(int amount) {
        for (Vehicle v : vehicles) {
            if (v.isRunning()) {
                double brake = ((double) amount) / 100;
                v.brake(brake);
            }
        }
    }

    @Override
    public void turnLeft() {
        for (Vehicle v : vehicles) {
            if (v.isRunning()) {
                v.turnLeft();
            }
        }
    }

    @Override
    public void turnRight() {
        for (Vehicle v : vehicles) {
            if (v.isRunning()) {
                {
                    v.turnRight();
                }
            }
        }
    }

    void turboOn() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOff();
            }
        }
    }
    @Override
    public void startEngine() {
        for (Vehicle v : vehicles) {
            if (!(v.isRunning())) {
                v.startEngine();
                v.setIsRunning(true);
            }
        }
    }
    @Override
    public void stopEngine() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
            v.setIsRunning(false);
        }
    }

    void raise(int amount) {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania scania) {
                scania.raise(amount);
            }
        }
    }

    void lower(int amount) {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania scania) {
                scania.lower(amount);
            }
        }
    }
}