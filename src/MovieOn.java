public class MovieOn extends On {
    public MovieOn()
    {
        super();
    }

    @Override
    public void downloadReset() {
        movieOff();
    }

    @Override
    public void movieOff() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.MOVIE_OFF);
    }
}
