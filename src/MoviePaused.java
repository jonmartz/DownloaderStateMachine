public class MoviePaused extends MovieOn {
    public MoviePaused()
    {
        super();
    }

    @Override
    public void resume() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.PLAYING_MOVIE);
    }
}
