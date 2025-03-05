package lab2_old;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    DrawPanel drawPanel;

    //private Garage<Volvo240> garage = new Garage<>();
    //VehicleManager vehicleManager;

        public static void main(String[] args) {
            // Instance of this class
            CarController cc = new CarController();
            cc.vehicleManager.vehicles.add(new Volvo240(0, 0));
            cc.vehicleManager.vehicles.add(new Saab95(0, 100));
            cc.vehicleManager.vehicles.add(new Scania(0, 200));

            cc.vehicleManager.garage = new Garage<Volvo240>();

            // Start a new view and send a reference of self
            cc.vehicleManager.frame = new CarView("CarSim 1.0", cc);

            // Start the timer
            cc.vehicleManager.timer.start();
        }
}

