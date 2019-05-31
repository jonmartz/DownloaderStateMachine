public abstract class AbstractState implements IState {
    @Override
    public IState turnOff() {
        return this;
    }

    @Override
    public IState turnOn() {
        return this;
    }

    @Override
    public IState internetOn() {
        return this;
    }

    @Override
    public IState internetOff() {
        return this;
    }

    @Override
    public IState downloadFinished() {
        return this;
    }

    @Override
    public IState downloadAborted() {
        return this;
    }

    @Override
    public IState downloadPaused() {
        return this;
    }

    @Override
    public IState downloadResumed() {
        return this;
    }

    @Override
    public IState downloadError() {
        return this;
    }

    @Override
    public IState downloadReset() {
        return this;
    }

    @Override
    public IState gettingRequest() {
        return this;
    }

    @Override
    public IState fileRequest() {
        return this;
    }

    @Override
    public IState processRequest() {
        return this;
    }

    @Override
    public IState movieOff() {
        return this;
    }

    @Override
    public IState movieOn() {
        return this;
    }

    @Override
    public IState holdMovie() {
        return this;
    }

    @Override
    public IState restartMovie() {
        return this;
    }

    @Override
    public IState errorFixed() {
        return this;
    }

    @Override
    public IState resume() {
        return this;
    }
}
