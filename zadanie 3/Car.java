import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is the main part
 * Car holds an array with different kind of information about itself
 * After given amount of miliseconds it displays the data in terminal
 * @author Szymon Bogusz
 */
public class Car implements ActionListener {

    ArrayList<Displayable> info = new ArrayList<Displayable>();

    private Timer timer;

    /**
     * Car creator which adds different classes which checks various information about car
     * @param time miliseconds after which the car updates data
     */
    public Car (int time) {
        //Timer to change data every second at first
        timer = new Timer(time, this);
        timer.start();

        Speed speed = new Speed();
        EngineTemp engineTemp = new EngineTemp();

        info.add(speed);
        info.add(engineTemp);
    }

    /**
     * This method goes through whole info array
     * And displays every piece of information
     */
    public void display () {
        for (Displayable i : info) {
            i.display();
        }
    }

    /**
     * This method tells car to output data every time the timer "ticks" using display method
     * @param e actionevent of timer
     */
	@Override
	public void actionPerformed(ActionEvent e) {
        display();
	}


    // this doesn't work for now but in the future
    /**
     * this method will allow user to change amount of miliseconds between "ticks"
    */ 
    public void changeTimer (int newTimer) {
        timer.stop();
        timer = new Timer(newTimer, this);
        timer.start();
    }

}