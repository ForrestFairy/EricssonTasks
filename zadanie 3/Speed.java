public class Speed implements Displayable {
    
    float speed;

    Speed() {
        this.speed = 0;
    }

    @Override
    public void display () {
        System.out.println(speed);
    }
}