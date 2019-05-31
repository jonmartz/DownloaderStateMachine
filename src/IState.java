public interface IState {
    AbstractState turnOff();
    AbstractState turnOn();
    // Internet
    AbstractState internetOn();
    AbstractState internetOff();
    // Downloads
    AbstractState downloadFinished();
    AbstractState downloadAborted();
    AbstractState downloadPaused();
    AbstractState downloadResumed();
    AbstractState downloadError();
    AbstractState downloadReset();
    // Requests
    AbstractState gettingRequest();
    AbstractState fileRequest();
    AbstractState processRequest();
    // Movie
    AbstractState movieOff();
    AbstractState movieOn();
    AbstractState holdMovie();
    AbstractState restartMovie();
    // TODO: what is that functions category?
    AbstractState errorFixed();
    AbstractState resume();
    //entery and exit
    void exit();

}
