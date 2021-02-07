import java.util.ArrayList;

public class Car {

    ArrayList <Displayable> info;

    public Car () {
        info.add(new Speed());
    }

    public void display () {
        for (Displayable i : info) {
            i.display();
        }
    }
}