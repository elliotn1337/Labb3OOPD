package lab2_old;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class VehicleManager extends Vehicle {

    DrawPanel drawPanel;
    CarView frame;
    CarController carC;

    public static List<Vehicle> vehicles = new ArrayList<>();
    //public static List<Vehicle> garages = new ArrayList<>();
    Garage<Volvo240> garage = new Garage<>();

    public void moveit(Vehicle v, int x, int y) {
        if (v instanceof Volvo240) {
            drawPanel.volvoPoint.x = x;
            drawPanel.volvoPoint.y = y;
        } else if (v instanceof Saab95) {
            drawPanel.saabPoint.x = x;
            drawPanel.saabPoint.y = y;
        } else if (v instanceof Scania) {
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
