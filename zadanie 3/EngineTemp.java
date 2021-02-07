/**
 * Displayable class which will hold current temperature of an engine
 */

public class EngineTemp implements Displayable {
    
    private float temperature;

    EngineTemp () {
        this.temperature = 80;
    }

    /**
     * This method will display current engine temperature in celcius to terminal
     */
    @Override
    public void display() {
        System.out.println("Engine temp: " + temperature + "°C");
    }
}