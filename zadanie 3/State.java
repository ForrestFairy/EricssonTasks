public class State {
    
    /**
     * state 0 - standing
     * state 1 - speeding up
     * state 2 - slowing down
     * state 3 - turning
     */
    private int state;
    private DisplayState curState;

    State(int state) {
        this.state = state;

        if (state == 0) curState = new Standing();
        if (state == 1) curState = new Speeding();
        if (state == 2) curState = new Slowing();
        if (state == 3) curState = new Turning();
    }

    public void changeState (int state) {
        this.state = state;

        if (state == 0) curState = new Standing();
        if (state == 1) curState = new Speeding();
        if (state == 2) curState = new Slowing();
        if (state == 3) curState = new Turning();
    }

    public int getState () {
        return state;
    }

    public void display () {
        System.out.println("----------------------");
        curState.displayState();
    }
}