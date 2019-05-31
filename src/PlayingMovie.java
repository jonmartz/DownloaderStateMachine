public class PlayingMovie extends MovieOn {
    public PlayingMovie()
    {
        super();
        System.out.println("movie playing");
    }

    @Override
    public void downloadPaused() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.DOWNLOAD_PAUSED);
    }

    @Override
    public void holdMovie() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.MOVIE_PAUSED);
    }

    @Override
    public void restartMovie() {
        Context.getInstance().playTime = 0;
    }

    @Override
    public void exit() {
        super.exit();
        System.out.println("movie stopped playing");
    }
}
