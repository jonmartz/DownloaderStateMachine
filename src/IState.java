public interface IState {
    void turnOff();
    void turnOn();
    // Internet
    void internetOn();
    void internetOff();
    // Downloads
    void downloadFinished();
    void downloadAborted();
    void downloadPaused();
    void downloadResumed();
    void downloadError();
    void downloadReset();
    // Requests
    void gettingRequest();
    void fileRequest(Movie movie);
    void processRequest();
    // Movie
    void movieOff();
    void movieOn();
    void holdMovie();
    void restartMovie();
    // TODO: what is that functions category?
    void errorFixed();
    void resume();
    //entery and exit
    void exit();
    void notifyTimerEnded(int eventID);
    void entry();
}
