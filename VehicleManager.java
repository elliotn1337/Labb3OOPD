package lab2_old;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class VehicleManager extends Vehicle {

    DrawPanel drawPanel;
    CarView carView;
    CarController carC;

    public List<Vehicle> vehicles = new ArrayList<>();

    void moveit(Vehicle car, int x, int y) {
        if (car instanceof Volvo240) {
            drawPanel.volvoPoint.x = x;
            drawPanel.volvoPoint.y = y;
        } else if (car instanceof Saab95) {
            drawPanel.saabPoint.x = x;
            drawPanel.saabPoint.y = y;
        } else if (car instanceof Scania) {
            drawPanel.scaniaPoint.x = x;
            drawPanel.scaniaPoint.y = y;}
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    //public void addVehicle(Vehicle v){
        //vehicles.add(v);
    //}

    public void updatePositions(){

    }

}
