public abstract class AbstractState implements IState {
    @Override
    public IState turnOff() {
        return null;
    }

    @Override
    public IState turnOn() {
        return null;
    }

    @Override
    public IState internetOn() {
        return null;
    }

    @Override
    public IState internetOff() {
        return null;
    }

    @Override
    public IState downloadFinished() {
        return null;
    }

    @Override
    public IState downloadAborted() {
        return null;
    }

    @Override
    public IState downloadPaused() {
        return null;
    }

    @Override
    public IState downloadResumed() {
        return null;
    }

    @Override
    public IState downloadError() {
        return null;
    }

    @Override
    public IState downloadReset() {
        return null;
    }

    @Override
    public IState gettingRequest() {
        return null;
    }

    @Override
    public IState fileRequest() {
        return null;
    }

    @Override
    public IState processRequest() {
        return null;
    }

    @Override
    public IState movieOff() {
        return null;
    }

    @Override
    public IState movieOn() {
        return null;
    }

    @Override
    public IState holdMovie() {
        return null;
    }

    @Override
    public IState restartMovie() {
        return null;
    }

    @Override
    public IState errorFixed() {
        return null;
    }

    @Override
    public IState resume() {
        return null;
    }
}
