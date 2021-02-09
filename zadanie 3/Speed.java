/**
 * Displayable class which will hold current speed of a Car
 */

public class Speed implements Displayable {
    
    private float speed;
    private float acceleration;
    private float decceleration;

    Speed() {
        this.speed = 0;
        this.acceleration = 1;
        this.decceleration = 2;
    }

    /**
     * This method will display current speed in km/h to terminal
     */
    @Override
    public void display () {
        System.out.println("Speed: " + speed + "km/h");
    }

    @Override
    public void standing() {

    }

    @Override
    public void speeding() {
        if (speed < 130) {
            speed += acceleration;
        }
        if (acceleration < 3.3) {
            acceleration += 0.75;
        }

        decceleration = 2;
    }

    @Override
    public void slowing() {
        if (speed > 0) speed -= decceleration;
        if (speed < 0) speed = 0;

        if (decceleration <= 10) {
            decceleration += 1;
        }

        acceleration = 1;
    }

    @Override
    public void turn() {
        speed -= 0.5;

        acceleration = 1;
        decceleration = 2;
    }

    public float getSpeed() {
        return speed;
    }
}