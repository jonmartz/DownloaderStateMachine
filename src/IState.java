package com.company;

public interface IState {
    IState turnOff();
    IState turnOn();
    // Internet
    IState internetOn();
    IState internetOff();
    // Downloads
    IState downloadFinished();
    IState downloadAborted();
    IState downloadPaused();
    IState downloadResumed();
    IState downloadError();
    IState downloadReset();
    // Requests
    IState gettingRequest();
    IState fileRequest();
    IState processRequest();
    // Movie
    IState movieOff();
    IState movieOn();
    IState holdMovie();
    IState restartMovie();
    // TODO: what is that functions category?
    IState errorFixed();
    IState resume();

}
