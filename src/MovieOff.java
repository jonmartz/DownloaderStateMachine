public class MovieOff extends On {
    public MovieOff()
    {
        super();
        Context.getInstance().playTime = 0;
    }

    @Override
    public void movieOn() {
        Movie movie = Context.getInstance().movie;
        if (movie != null && movie.checkDownloadProgress()>=0.2){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.PLAYING_MOVIE);
        }
    }
}
