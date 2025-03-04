package lab2_old;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class VehicleManager extends Vehicle {
    CarView frame;
    private final int delay = 50;

    List<Vehicle> vehicles = new ArrayList<>();
    Garage<Volvo240> garage = new Garage<>();

    protected Timer timer = new Timer(delay, new TimerListener());

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    //public void addVehicle(Vehicle v){
        //vehicles.add(v);
    //}

    //public void updatePositions(){}

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicles) {

                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                //System.out.printf("%s\t%s\n", car.getClass(), car.getCurrentSpeed());

                if (car.getX() < 0 || car.getX() > 800 || car.getY() < 0 || car.getY() > 800) {
                    //if (car instanceof Volvo240 && car.getX()
                    car.turnLeft();
                    car.turnLeft();
                    //car.stopEngine();
                }

                if (275.0 < car.getX() && car.getX() < 325.0 && 275 < car.getY() && car.getY() < 325) {
                    if (car instanceof Volvo240 v) {
                        if (!car.getIsLoaded()) {
                            garage.loadVehicle(v);
                            car.setX(300);
                            car.setY(300);
                            v.stopEngine();

                        }
                    }
                }
            }
        }



}
}
