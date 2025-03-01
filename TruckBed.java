package lab2_old;
public class TruckBed {

    protected int angle;
    protected int getAngle(){return angle;}

    public void setAngle(int ang, double speed) {
        if (speed == 0) {
            if (angle >= 0 && 70 >= angle) {
                angle = ang;
            } else {
                throw new IllegalArgumentException("Angle should be between 0 and 70 degrees");
            }
        } else {
            throw new IllegalArgumentException("Speed must be 0 to change angle");
        }
    }


    public void Raise(int degrees, double speed) {
        int ang = getAngle();
        int newAng = ang + degrees;
        if ( newAng > 70){
        setAngle(70, speed);}

    setAngle(newAng, speed);

    }

    public void Lower(int degrees, double speed){
        int ang = getAngle();
        int newAng = ang - degrees;
        if ( newAng < 0){
            setAngle(0, speed);
        }

        setAngle(newAng, speed);}


}
