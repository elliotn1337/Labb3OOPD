package lab2_old;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarController {
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
    private int i = 0;
    protected VehicleManager vehicleManager;
    DrawPanel drawPanel;
    BufferedImage volvoImage;

    public CarController() {
        this.vehicleManager = new VehicleManager();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        for (Vehicle v : vehicleManager.vehicles) {
            double gas = ((double) amount) / 100;
            if (v.isRunning()) {
                v.gas(gas);
            }
        }
    }

    void brake(int amount) {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v.isRunning()) {
                double brake = ((double) amount) / 100;
                v.brake(brake);
            }
        }
    }

    //@Override
    void turnLeft() {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v.isRunning()) {
                v.turnLeft();
            }
        }
    }

    //@Override
    void turnRight() {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v.isRunning()) {
                {
                    v.turnRight();
                }
            }
        }
    }

    void turboOn() {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOff();
            }
        }
    }

    //@Override
    void startEngine() {
        for (Vehicle v : vehicleManager.vehicles) {
            if (!(v.isRunning())) {
                v.startEngine();
                v.setIsRunning(true);
            }
        }
    }

    //@Override
    void stopEngine() {
        for (Vehicle v : vehicleManager.vehicles) {
            v.stopEngine();
            v.setIsRunning(false);
        }
    }

    void raise(int amount) {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v instanceof Scania scania) {
                scania.raise(amount);
            }
        }
    }

    void lower(int amount) {
        for (Vehicle v : vehicleManager.vehicles) {
            if (v instanceof Scania scania) {
                scania.lower(amount);
            }
        }
    }

    void addCar() {
        if (!(vehicleManager.vehicles.size() >= 10)) {
            //String vehicleName = "Volvo240" + i;
            Volvo240 newV = new Volvo240(0,0);
            vehicleManager.vehicles.add(newV);
            Point newPoint = new Point();
            drawPanel.vehiclePositions.put(newV, newPoint);
            //drawPanel.vehicleImages.(newV, volvoImage);
            //i = i + 1;


        }
    }
}