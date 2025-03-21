package lab2_old;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Point;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    public Map<Vehicle, Point> vehiclePositions = new HashMap<>();
    public Map<Class<? extends Vehicle>, BufferedImage> vehicleImages = new HashMap<>();

    /*public void carImage(){

        // Skapa bilar som ska användas både för bilder och positioner

        // Lägg till bilarna i vehicleImages med tillhörande bilder
        vehicleImages.put(volvo, volvoImage);
        vehicleImages.put(saab, saabImage);
        vehicleImages.put(scania, scaniaImage);

        // Lägg till bilarna i vehiclePositions med deras initiala positioner
        vehiclePositions.put(volvo, new Point(0, 0));
        vehiclePositions.put(saab, new Point(0, 100));
        vehiclePositions.put(scania, new Point(0, 200));
        }*/



    BufferedImage volvoImage;
    Point volvoPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);
    BufferedImage saabImage;
    Point saabPoint = new Point();

    BufferedImage scaniaImage;
    Point scaniaPoint = new Point();

    // TODO: Make this general for all cars

    public void loadImages(){
    try{
        vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        vehicleImages.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
    }
    catch (IOException ex){
        ex.printStackTrace();
    }
}


    public void moveit(Vehicle v, int x, int y) {
        // if (vehiclePositions.containsKey(v)) {
            //vehiclePositions.get(v).setLocation(x, y);
            vehiclePositions.put(v, new Point(x, y));
        // }
        //if (v instanceof Saab95) {
            //saabPoint.x = x;
          //  saabPoint.y = y;
        //} else if (v instanceof Volvo240) {
            //volvoPoint.x = x;
          //  volvoPoint.y = y;
        //} else if (v instanceof Scania) {
           // scaniaPoint.x = x;
         //   scaniaPoint.y = y;
       // }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));+
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Map.Entry<Vehicle, Point> entry : vehiclePositions.entrySet()) {
            BufferedImage img = vehicleImages.get(entry.getKey().getClass());
            if (img != null) {
                g.drawImage(img, entry.getValue().x, entry.getValue().y, null);
            }
            //Vehicle car = entry.getKey();
            //Point point = entry.getValue();
            //BufferedImage carImage = vehicleImages.get(car);

            //g.drawImage(vehicleImages, point.x, point.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null) ;
        }}

        /*g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        */
}





