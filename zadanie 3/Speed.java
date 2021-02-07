/**
 * Displayable class which will hold current speed of a Car
 */

public class Speed implements Displayable {
    
    private float speed;

    Speed() {
        this.speed = 0;
    }

    /**
     * This method will display current speed in km/h to terminal
     */
    @Override
    public void display () {
        System.out.println("Speed: " + speed + "km/h");
    }
}