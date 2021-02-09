import java.text.DecimalFormat;

/**
 * Displayable class which will hold current temperature of an engine
 */
public class EngineTemp implements Displayable {
    
    private static DecimalFormat df = new DecimalFormat("0.00");
    private float temperature;

    EngineTemp () {
        this.temperature = 0;
    }

    /**
     * This method will display current engine temperature in celcius to terminal
     */
    @Override
    public void display() {
        System.out.println("Engine temp: " + df.format(temperature) + "°C");
    }

    @Override
    public void standing() {
        if (temperature < 80) {
            temperature += 20;
            if (temperature > 80) temperature = 80;
        }
        
        if (temperature > 80) temperature -= 3;
    }

    @Override
    public void speeding() {
        if (temperature < 95) temperature += 0.1;
    }

    @Override
    public void slowing() {
        if (temperature < 95) temperature += 0.05;
    }

    @Override
    public void turn() {
        if (temperature < 95) temperature += 0.1;
    }
}