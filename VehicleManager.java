package lab2_old;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class VehicleManager  {
    CarView frame;
    private final int delay = 50;

    public Stack<Vehicle> vehicles = new Stack<>();

    Garage<Volvo240> garage = new Garage<>();

    protected Timer timer = new Timer(delay, new TimerListener());

    private Random random = new Random();

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicles) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.loadImages();
                frame.drawPanel.moveit(car, x, y);
                //drawPanel.vehiclePositions.put(car, new Point(x, y));
                //drawPanel.vehicleImages.put(car, image);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                System.out.printf("%s\t%s\n", car.getX(), car.getY());
                System.out.println(car);

                if (car.getX() < 0 || car.getX() > 685 || car.getY() < 0 || car.getY() > 500) {
                    //if (car instanceof Volvo240 && car.getX()
                    car.turnLeft();
                    car.turnLeft();
                    //car.stopEngine();
                }

                if (275.0 < car.getX() && car.getX() < 325.0 && 275 < car.getY() && car.getY() < 325) {
                    if (car instanceof Volvo240 v) {
                        if (!car.getIsLoaded()) {
                                garage.loadVehicle(v);
                                car.setIsRunning(false);
                                car.setX(300);
                                car.setY(300);
                                v.stopEngine();


                        }
                    }
                }
            }
        }
    }

    void gas(int amount) {
        for (Vehicle v : vehicles) {
            double gas = ((double) amount) / 100;
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

    //@Override
    void turnLeft() {
        for (Vehicle v : vehicles) {
            if (v.isRunning()) {
                v.turnLeft();
            }
        }
    }

    //@Override
    void turnRight() {
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

    //@Override
    void startEngine() {
        for (Vehicle v : vehicles) {
            if ((!(v.isRunning())) && (!(v.getIsLoaded()))) {
                v.startEngine();
                v.setIsRunning(true);
            }
        }
    }

    //@Override
    void stopEngine() {
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

    void addCar() {
        if (!(vehicles.size() >= 10)) {
            //String vehicleName = "Volvo240" + i;
            int randomCoord = random.nextInt(500);
            Volvo240 newV = new Volvo240(0,randomCoord);
            vehicles.add(newV);
            Point newPoint = new Point();
            CarView.drawPanel.vehiclePositions.put(newV, newPoint);
            //drawPanel.vehicleImages.(newV, volvoImage);
            //i = i + 1;


        }
    }
    void removeCar(){
        if (!vehicles.isEmpty()) {
            int randomIndex = random.nextInt(vehicles.size());
            Vehicle removedCar = vehicles.remove(randomIndex);
            CarView.drawPanel.vehiclePositions.remove(removedCar);

        }}

    void deloadCar() {
        if (garage.getGarageLoaded() > 0) {
            int randomIndex = random.nextInt(garage.getGarageLoaded());

            Vehicle removedCar = garage.deloadVehicle(randomIndex);


            CarView.drawPanel.vehiclePositions.put(removedCar, new Point(400,300));
            removedCar.setIsRunning(true);
            removedCar.setX(400);removedCar.setIsLoaded(false);removedCar.startEngine();

        }
    }
}
