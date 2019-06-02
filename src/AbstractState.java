public abstract class AbstractState implements IState {


    protected AbstractState()
    {
        Class<?> enclosingClass = this.getClass().getEnclosingClass();
        if (enclosingClass != null) {

            System.out.println("enter "+enclosingClass.getName()+" state");
        } else {
            System.out.println("enter "+this.getClass().getName()+" state");
        }
    }
    @Override
    public void turnOff() {

    }

    @Override
    public void entry() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void downloadFinished() {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadPaused() {

    }

    @Override
    public void downloadResumed() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void downloadReset() {

    }

    @Override
    public void gettingRequest() {

    }

    @Override
    public void fileRequest(Movie movie) {

    }

    @Override
    public void processRequest() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void exit() {
        Class<?> enclosingClass = this.getClass().getEnclosingClass();
        if (enclosingClass != null) {
            System.out.println("exit "+enclosingClass.getName()+" state");
        } else {
            System.out.println("exit "+this.getClass().getName()+" state");
        }
    }

    @Override
    public void notifyTimerEnded(int eventID) { }
}
