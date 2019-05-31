public abstract class AbstractState implements IState {
    @Override
    public AbstractState turnOff() {
        return this;
    }

    @Override
    public AbstractState turnOn() {
        return this;
    }

    @Override
    public AbstractState internetOn() {
        return this;
    }

    @Override
    public AbstractState internetOff() {
        return this;
    }

    @Override
    public AbstractState downloadFinished() {
        return this;
    }

    @Override
    public AbstractState downloadAborted() {
        return this;
    }

    @Override
    public AbstractState downloadPaused() {
        return this;
    }

    @Override
    public AbstractState downloadResumed() {
        return this;
    }

    @Override
    public AbstractState downloadError() {
        return this;
    }

    @Override
    public AbstractState downloadReset() {
        return this;
    }

    @Override
    public AbstractState gettingRequest() {
        return this;
    }

    @Override
    public AbstractState fileRequest() {
        return this;
    }

    @Override
    public AbstractState processRequest() {
        return this;
    }

    @Override
    public AbstractState movieOff() {
        return this;
    }

    @Override
    public AbstractState movieOn() {
        return this;
    }

    @Override
    public AbstractState holdMovie() {
        return this;
    }

    @Override
    public AbstractState restartMovie() {
        return this;
    }

    @Override
    public AbstractState errorFixed() {
        return this;
    }

    @Override
    public AbstractState resume() {
        return this;
    }

    @Override
    public void exit() {

    }
}