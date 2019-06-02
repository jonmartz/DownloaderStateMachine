public class TimeEvent implements Runnable{

    public IState state;
    public int eventID;
    public int seconds;

    public TimeEvent(IState state, int eventID, int seconds) {
        this.state = state;
        this.eventID = eventID;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds*1000);
            state.notifyTimerEnded(eventID);
        } catch (InterruptedException e) { }
    }
}
