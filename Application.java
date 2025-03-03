package lab2_old;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    private final int delay = 50;
    CarView frame;
    VehicleManager vehicleManager;

    private Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : VehicleManager.vehicles) {

                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                System.out.printf("%s\t%s\n", car.getClass(), car.getCurrentSpeed());
                frame.vehicleManager.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (car.getX() < 0 || car.getX() > 800 || car.getY() < 0 || car.getY() > 800) {
                    //if (car instanceof Volvo240 && car.getX()
                    car.turnLeft();
                    car.turnLeft();
                    //car.stopEngine();
                }

                if (275.0 < car.getX() && car.getX() < 325.0 && 275 < car.getY() && car.getY() < 325){
                    if (car instanceof Volvo240 v) {
                        if (!car.getIsLoaded()){
                            garage.loadVehicle(v);
                            ((Volvo240) car).setX(300);
                            car.setY(300);
                            v.stopEngine();

                        }
                    }

                }
            }
        }
    }
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Saab95(0, 100));
        cc.vehicles.add(new Scania(0, 200));
        cc.vehicles.add(new Volvo240(0,0));
        cc.garage = new Garage<Volvo240>();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

    }
}
