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

    private ArrayList<Displayable> info = new ArrayList<Displayable>();
    private State currentState;
    private Timer timer;
    private Timer updater;

    private int timePassed = 0;

    /**
     * Car creator which adds different classes which checks various information about car
     * @param time miliseconds after which the car updates data
     */
    public Car (int time) {
        //Timer to change data every second at first
        updater = new Timer(1000, this);
        updater.start();
        //Timer to display every given milliseconds
        timer = new Timer(time, this);
        timer.start();

        Speed speed = new Speed();
        EngineTemp engineTemp = new EngineTemp();

        info.add(speed);
        info.add(engineTemp);

        this.currentState = new State(0);
    }

    /**
     * If no time was given, use 1 second timer
     */
    public Car () {
        updater = new Timer(1000, this);
        updater.start();
        //Timer to display every given milliseconds
        timer = new Timer(1000, this);
        timer.start();

        Speed speed = new Speed();
        EngineTemp engineTemp = new EngineTemp();

        info.add(speed);
        info.add(engineTemp);

        this.currentState = new State(0);
    }

    /**
     * This method tells car to output data every time the timer "ticks" using display method
     * Or udate data every updater "tick"
     * @param e actionevent of timer or updater
     */
	@Override
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == updater) {
            update(currentState);

            /**
             * just for visualization
             */
            timePassed++;
            simpleVisualization();
        }

        if (e.getSource() == timer) {
            display();
        }
        
	}

    /**
     * Method to be called every second to update info
     * @param curState might be standing, speeding, slowing or turning
     */
    public void update(State curState) {
        
        if (curState.getState() == 0) 
            for (Displayable i : info)
                i.standing(); 
        if (curState.getState() == 1) 
            for (Displayable i : info)
                i.speeding(); 
        if (curState.getState() == 2) 
            for (Displayable i : info)
                i.slowing(); 
        if (curState.getState() == 3) 
            for (Displayable i : info)
                i.turn(); 
    }
    
    /**
     * This method goes through whole info array
     * And displays every piece of information
     */
    public void display () {
        currentState.display();
        for (Displayable i : info) {
            i.display();
        }
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

    public void simpleVisualization() {
        if (timePassed == 5) currentState.changeState(1);
        if (timePassed == 15) currentState.changeState(2);
        if (timePassed == 17) currentState.changeState(3);
        if (timePassed == 20) currentState.changeState(1);
        if (timePassed == 35) currentState.changeState(2);
        if (timePassed == 40) currentState.changeState(3);
        if (timePassed >= 43) {
            if (((Speed) info.get(0)).getSpeed() == 0) {
                currentState.changeState(0);
            }
            else { currentState.changeState(2); }
        }
    }
}