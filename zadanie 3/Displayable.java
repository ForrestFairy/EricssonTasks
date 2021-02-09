/**
 * Interface to implement by classes which will check some data
 * And they will have to have an option to display that data
 */

public interface Displayable {
    
    /**
     *  Every piece of information should be displayable to terminal
     */
    public void display ();

    /**
     * Method to be called while car is standing still
     */
    public void standing ();

    /**
     * Method to be called while car is speeding up
     */
    public void speeding ();

    /**
     * Method to be called while car is slowing down
     */
    public void slowing ();

    /**
     * Method to be called while car is turning
     */
    public void turn ();
}