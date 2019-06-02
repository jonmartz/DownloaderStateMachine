public class TimeEvent extends Thread {

    public IState state;
    public int eventID;
    public double seconds;
    public boolean isInterrupted;
    public TimeEvent(IState state, int eventID, double seconds) {
        this.state = state;
        this.eventID = eventID;
        this.seconds = seconds;
        this.isInterrupted = false;
    }

    @Override
    public void run() {
        try {
            isInterrupted=false;
            Thread.sleep((int)(seconds*1000));
            if(!isInterrupted)
                state.notifyTimerEnded(eventID);
        } catch (InterruptedException e) { }
    }

    @Override
    public void interrupt() {
        this.isInterrupted = true;
        super.interrupt();

    }
}
