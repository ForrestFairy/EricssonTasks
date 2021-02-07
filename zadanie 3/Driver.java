/**
 * This class should be used to start Car class
 * put in terminal "java Driver x" 
 * where x is the miliseconds between "ticks" of car
 * the lower the x the shorter will be intervals between updating data
 */

public class Driver {
    
    public static void main(String[] args) {

        int time = Integer.valueOf(args[0]);
        Car car = new Car(time);
        while (true) {}
    } 
}