public class PlayingMovie extends MovieOn {

    private TimeEvent timeEvent;
    private long start;
    public PlayingMovie()
    {
        super();
        System.out.println("movie playing");
        play();
    }

    private void play()
    {
        start = System.currentTimeMillis();
        timeEvent=new TimeEvent(this,3,Context.getInstance().movie.getLengthInSeconds()-Context.getInstance().playTime);
        timeEvent.start();
    }
    @Override
    public void downloadPaused() {
        Context.getInstance().playTime = (int)((System.currentTimeMillis() -start)/1000);
        timeEvent.interrupt();
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.DOWNLOAD_PAUSED);
    }

    @Override
    public void holdMovie() {
        Context.getInstance().playTime = (int)((System.currentTimeMillis() -start)/1000);
        timeEvent.interrupt();
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.MOVIE_PAUSED);
    }

    @Override
    public void restartMovie() {
        timeEvent.interrupt();
        Context.getInstance().playTime = 0;
        play();
    }

    @Override
    public void exit() {
        super.exit();
        System.out.println("movie stopped playing");
    }

    @Override
    public void notifyTimerEnded(int eventID) {
        movieOff();
    }
}
